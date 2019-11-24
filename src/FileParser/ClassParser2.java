package FileParser;

import SearchObjects.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassParser2 {

    public static void main(String[] args) {
        String reptile = "package CodeBase;\n" +
                "\n" +
                "public class Rabbit extends Mammal {\n" +
                "    String color;\n" +
                "    int numSiblings;\n" +
                "    Rabbit father;\n" +
                "\n" +
                "    protected class Mutt {\n" +
                "        String secondaryColor;\n" +
                "    }\n" +
                "}\n";
        List<String> reptileLines = Arrays.asList(reptile.split("\n"));
        String[] a = refineText(reptileLines);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        ClassObject file = fileParser("Path", reptileLines);
        System.out.println("Size: " + file.getAttributes().size());
        for (int i = 0; i < file.getAttributes().size(); i++) {
            System.out.println(file.getAttributes().get(i).toString());
        }
        //System.out.println(file.toString());
    }

    public static ClassObject fileParser(String path, List<String> content) {
        String[] refined = refineText(content);
        ClassObject javaFile = classParser(refined, path);
        return javaFile;
    }

    private static int i = 1;

    public static ClassObject classParser(String[] refinedText, String path) {
        int number = Integer.parseInt(refinedText[0].substring(0, refinedText[0].indexOf(' ')));
        ClassObject classObject = classHeadParser(refinedText[0]);
        classObject.setLine(number);
        classObject.setClasses(new ArrayList<>());
        classObject.setMethods(new ArrayList<>());
        classObject.setAttributes(new ArrayList<>());
        for (; i < refinedText.length; i++) {
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
        boolean isMethod = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < content.size(); i++) {
            content.set(i, content.get(i).replaceAll("  ", ""));
        }
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).contains("{") || (content.get(i).contains("}") && isMethod)) {
                result.append(i + " " + content.get(i) + "\n");
                continue;
            }
            if (content.get(i).isEmpty() || content.get(i).isBlank() || isMethod
                    || content.get(i).contains("import ") || content.get(i).contains("package ")) {
                continue;
            }
            if (content.get(i).contains(")")) {
                isMethod = true;
            }
            result.append(i + " " + content.get(i) + "\n");
        }
        /*boolean isClass = true;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < content.size(); i++) {
            content.set(i, content.get(i).replaceAll("  ",""));
        }
        for (int i = 0; i < content.size(); i++) {

            if ((!content.get(i).contains("class ") || !content.get(i).contains("interface ")
                    || !content.get(i).contains("enum ")) && content.get(i).contains("{")) {
                String replace = i + " " + content.get(i) + "\n";
                result.append(replace);
                isClass = false;
            }
            if (content.get(i).contains("}")) {
                result.append(i+" "+content.get(i) + "\n");
                isClass = true;
                continue;
            }
            if (content.get(i).isEmpty() || content.get(i).isBlank() || !isClass
                    || content.get(i).contains("import ") || content.get(i).contains("package ")) {
                continue;
            }
            String replace = i + " " + content.get(i) + "\n";
            result.append(replace);
        }*/

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
        if (back[0].isEmpty()) {
            return result;
        }
        List<FieldObject> parameters = new ArrayList<>();
        for (String param : back) {
            parameters.add(fieldParser(param, path));
        }
        parameters.forEach(x -> x.setLine(number));
        result.setParameters(parameters);
        return result;
    }

}
