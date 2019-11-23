package FileParser;

import SearchObjects.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassParser2 {

    public static void main(String[] args) {
        String[] test = {"import Doggy.*;", "public class Dog {", "private int b;", "public int a(int b, int a) {",
                "int a = 4;", "int b = 2;", "}", "private int c;", "}"};

        String wtf = test.toString();
        test = refineText(Arrays.asList(test));
        ClassObject lol = classParser(test, "path");
        System.out.println(Arrays.toString(test));
        System.out.println(lol.toString());
    }

    public static ClassObject classParser(String[] refinedText, String path) {
        int number = Integer.parseInt(refinedText[0].substring(0, refinedText[0].indexOf(' ')));
        ClassObject classObject = classHeadParser(refinedText[0]);
        classObject.setLine(number);
        classObject.setClasses(new ArrayList<>());
        classObject.setMethods(new ArrayList<>());
        classObject.setAttributes(new ArrayList<>());
        for (int i = 1; i < refinedText.length; i++) {
            String line = getChunk(refinedText, i);
            if (line.contains("class ")) {
                String[] inClassText = line.split("\n");
                classObject.getClasses().add(classParser(inClassText, path));
            }
            if (line.contains(";")) {
                classObject.getAttributes().add(fieldParser(line, path));
            }
            if (line.contains("(") && line.contains(")")) {
                classObject.getMethods().add(methodParser(line, path));
            }
        }
        return classObject;
    }

    public static ClassObject classHeadParser(String head) {
        boolean[] checkList = new boolean[3];
        checkList[0] = head.contains("implements ");
        checkList[1] = head.contains("extends ");
        checkList[2] = head.contains("<") && head.contains(">");
        String sub = head.substring(head.indexOf("class ") + 6);
        String name = sub.substring(0, sub.indexOf(" "));
        ClassObject.InheritanceType type = ClassObject.InheritanceType.DEFAULT;
        if (head.contains("abstract "))
            type = ClassObject.InheritanceType.ABSTRACT;
        else if (head.contains("final "))
            type = ClassObject.InheritanceType.FINAL;
        ClassObject.ClassType classType = ClassObject.ClassType.DEFAULT;
        if (head.contains("enum "))
            classType = ClassObject.ClassType.ENUM;
        else if (head.contains("interface "))
            classType = ClassObject.ClassType.INTERFACE;
        return new ClassObject(name, visibilityParser(head), checkList[1], checkList[2],
                checkList[0], type, classType, null);
    }

    public static String getChunk(String[] code, int index) {
        if (index >= code.length || index < 0) {
            return null;
        }
        for (int i = 0; i < code.length; i++) {
            if (i == index && code[i].contains("class ") && code[i].contains("{")) {
                StringBuilder build = new StringBuilder();
                int open = 0;
                do {
                    if (code[i].contains("}")) {
                        open--;
                    }
                    if (code[i].contains("{")) {
                        open++;
                    }
                    build.append(code[i] + "\n");
                    i++;
                } while (open != 0);
                return build.toString();
            }
            if (i == index && code[i].contains("(")) {
                return code[i];
            }
            if (i == index && code[i].contains(";")) {
                return code[i];
            }
        }
        return code[index];
    }

    /**
     * Creates a shorter, filtered version of the code, so it can be parsed easily.
     *
     * @param content: All the Code in a List with each line as an element
     * @return String[]: Filtered version with only necessary Code with index in front
     */
    public static String[] refineText(List<String> content) {
        boolean isClass = true;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < content.size(); i++) {
            content.get(i).replace("    ", "");
            if ((!content.get(i).contains("class ") || !content.get(i).contains("interface ")
                    || !content.get(i).contains("enum ")) && content.get(i).contains("{")) {
                String replace = i + " " + content.get(i) + "\n";
                result.append(replace);
                isClass = false;
            }
            if (content.get(i).equals("}")) {
                isClass = true;
            }
            if (content.get(i).isEmpty() || content.get(i).isBlank() || !isClass
                    || content.get(i).contains("import ")) {
                continue;
            }
            String replace = i + " " + content.get(i) + "\n";
            result.append(replace);
        }
        return result.toString().split("\n");
    }

    /**
     * @param content: String of the class/method/field
     * @return AccesModifier: Enum of visibility
     */
    public static SearchObject.AccessModifier visibilityParser(String content) {
        if (content.contains("public")) {
            return SearchObject.AccessModifier.PUBLIC;
        } else if (content.contains("private")) {
            return SearchObject.AccessModifier.PRIVATE;
        } else if (content.contains("protected")) {
            return SearchObject.AccessModifier.PROTECTED;
        } else {
            return SearchObject.AccessModifier.DEFAULT;
        }
    }

    /**
     * @param fieldString: Insert a single line of a Field (private int p)
     * @param path:        Path of .java
     * @return FieldObject: A FieldObject
     */
    public static FieldObject fieldParser(String fieldString, String path) {
        int number = 0;
        try {
             number = Integer.parseInt(fieldString.substring(0, fieldString.indexOf(' ')));
        } catch (Exception e) {
        }
        String[] stream = fieldString.split(" ");
        FieldObject fieldObject = new FieldObject(stream[stream.length - 1], visibilityParser(fieldString), path, 0, stream[stream.length - 2]);
        fieldObject.setLine(number);
        return fieldObject;
    }

    /**
     * @param method: String of the headerline of a method
     * @param path:   Path of .java
     * @return: MethodObject: A MethodObject with List of Parameters
     */
    public static MethodObject methodParser(String method, String path) {
        int number = Integer.parseInt(method.substring(0, method.indexOf(" ")));
        String[] front = method.substring(0, method.indexOf('(')).split(" ");
        String[] back = method.substring(method.indexOf('(') + 1, method.indexOf(')')).split(", ");
        MethodObject result = null;

        result = new MethodObject(front[front.length - 1], visibilityParser(method), path, 0, null, method.contains("static"), front[front.length - 2]);
        result.setLine(number);
        List<FieldObject> parameters = new ArrayList<>();
        for (String param : back) {
            parameters.add(fieldParser(param, path));
        }
        parameters.forEach(x -> x.setLine(number));
        result.setParameters(parameters);
        return result;
    }

}
