package FileParser;

import SearchObjects.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassParser2 {
    public static String[] taboo = {"if", "else", "switch", "while", "return", "for", "do", "++", "--", "break;", "continue;", "System."};

    public static void main(String[] args) {

    }
    public static ClassObject fileParser(String path, List<String> content) {
        String[] tags = documentation(content);
        String[] refinedText = refineText(content);
        int number = Integer.parseInt(refinedText[0].substring(0, refinedText[0].indexOf(' ')));
        ClassObject classObject = classHeadParser(refinedText[0]);
        classObject.setLine(number);
        classObject.setPath(path);
        classObject.setTags(tags);
        classObject.setMethods(new ArrayList<>());
        classObject.setAttributes(new ArrayList<>());
        for (int i = 1; i < refinedText.length; i++) {
            String line = refinedText[i];
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
        String name = "";
        ClassObject.InheritanceType type;
        ClassObject.ClassType classType;
        if (head.contains("abstract ")) {
            type = ClassObject.InheritanceType.ABSTRACT;
        } else if (head.contains("final ")) {
            type = ClassObject.InheritanceType.FINAL;
        } else {
            type = ClassObject.InheritanceType.DEFAULT;
        }
        if (head.contains("enum ")) {
            classType = ClassObject.ClassType.ENUM;
            name = head.substring(head.indexOf("enum") + 5);
        } else if (head.contains("interface ")) {
            classType = ClassObject.ClassType.INTERFACE;
            name = head.substring(head.indexOf("interface") + 10);
        } else {
            classType = ClassObject.ClassType.DEFAULT;
            name = head.substring(head.indexOf("class") + 5);
        }

        if (checkList[2]) {
            name = name.substring(0, name.indexOf("<"));
        } else {
            name = name.substring(0, name.indexOf(" "));
        }

        return new ClassObject(name, visibilityParser(head), checkList[1], checkList[2],
                checkList[0], type, classType, null);
    }

    /**
     * Creates a shorter, filtered version of the code, so it can be parsed easily.
     *
     * @param content: All the Code in a List with each line as an element
     * @return String[]: Filtered version with only necessary Code with index in front
     */
    public static String[] refineText(List<String> content) {
        for (int i = 0; i < content.size(); i++) {
            content.set(i, content.get(i).replaceAll("\\t", ""));
            content.set(i, content.get(i).replaceAll("  ", ""));
            if (!isLegalField(content.get(i))) {
                content.set(i, "");
            } else {
                if (content.get(i).contains("//")) {
                    String x = content.get(i);
                    content.set(i, x.substring(0, x.indexOf("//")));
                }
            }
        }
        boolean isMethod = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < content.size(); i++) {
            if (isMethod && content.get(i).contains("}")) {
                isMethod = false;
                continue;
            }
            if (isMethod || content.get(i).startsWith("}"))
                continue;
            if (content.get(i).isEmpty() || content.get(i).isBlank()
                    || content.get(i).contains("import ") || content.get(i).contains("package ") || content.get(i).contains("this.")) {
                continue;
            }
            if (content.get(i).contains(")")) {
                isMethod = true;
            }
            result.append((i + 1) + " " + content.get(i) + "\n");
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


    public static String[] documentation(List<String> content) {
        StringBuilder comments = new StringBuilder();
        for (int i = 0; i < content.size(); i++) {
            String line = content.get(i);
            content.set(i, line.replaceAll("\\t", ""));
            content.set(i, line.replaceAll("  ", ""));
            if (line.contains("/*") || line.contains("//") || line.contains("*/") || line.contains("*")) {
                content.set(i, line.replaceAll("//", ""));
                content.set(i, line.replaceAll("/*", ""));
                content.set(i, line.replaceAll("\\*/", ""));
                content.set(i, line.replaceAll("\\*", ""));
                if (line.length() > 10)
                    comments.append(line);
            }
        }

        String[] result = comments.toString().split(" ");
        result = Arrays.stream(result).filter(x -> x.length() > 5).distinct().toArray(String[] :: new);
        return result;
    }

    /**
     * @param fieldString: Insert a single line of a Field (private int p)
     * @param path:        Path of .java
     * @return FieldObject: A FieldObject
     */
    public static FieldObject fieldParser(String fieldString, String path) {
        if (fieldString.contains("=")) {
            fieldString = fieldString.substring(0, fieldString.indexOf("="));
        }
        int number = 0;
        try {
            number = Integer.parseInt(fieldString.substring(0, fieldString.indexOf(' ')));
        } catch (Exception e) {
        }
        String[] stream = fieldString.split(" ");
        String name = stream[stream.length - 1];
        if (name.contains(";"))
            name = name.substring(0, name.length() - 1);
        FieldObject fieldObject = new FieldObject(name, visibilityParser(fieldString), path, 0, stream[stream.length - 2]);
        fieldObject.setLine(number);
        return fieldObject;
    }

    public static boolean isLegalField(String line) {
        for (int i = 0; i < taboo.length; i++) {
            if (line.contains(taboo[i])) {
                return false;
            }
        }
        if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*/") || line.contains("*")) {
            return false;
        }
        return true;
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

        result = new MethodObject(front[front.length - 1], visibilityParser(method), path, 0, method.contains("static"), front[front.length - 2]);
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
