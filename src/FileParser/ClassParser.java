package FileParser;

import SearchObjects.*;

import java.util.ArrayList;
import java.util.List;

public class ClassParser {
    /**
     * Iterates over a file, finding and parsing all the SearchObjects in it, adding them to a list
     * and returning that list
     *
     * @param path:    path of the .java file we have to parse
     * @param content: content is the String-List read by {@link JavaFileReader}
     * @return A list of SearchObjects that were found in the java file
     */
    static ArrayList<SearchObject> parse(String path, List<String> content) {
        ArrayList<SearchObject> objects = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            if ((content.get(i).contains("class ") || content.get(i).contains("interface")) && realClass(content.get(i))) {
                ClassObject classObject = parseClassDecLine(getDeclarationLine(content, i));
                classObject.setPath(path);
                classObject.setLine(i);
                getContent(content, i);
                System.out.println(classObject.toString());
                extractContent(getContent(content, i), classObject);
            }
        }
        return null;
    }

    /**
     * Checks whether or not the String "class " here actually belongs to the program or to a comment
     *
     * @param string: the line to be checked for comments
     * @return true if the keyword class is outside of comments, else false
     */
    private static boolean realClass(String string) {
        if (!string.contains("//") && !string.contains("*") && !string.contains("/*") && !string.contains("/**")) {
            return true;
        }
        // else we have to determine whether the keyword itself is commented or legit
        string = string.substring(0, string.indexOf(" class "));
        if (!string.contains("//") && !string.contains("*") && !(string.contains("/*")) && !string.contains("/**")) {
            return true;
        } else {
            return false;
        }
    }

    private static void extractContent(String content, ClassObject classObject) {
        System.out.println(content);
    }

    /**
     * Extracts the raw content of a class as a String
     *
     * @param content: the content of the file with the class to be extracted
     * @param i:       index of the start of the class
     * @return String containing whats inside the class for further parsing
     */
    private static String getContent(List<String> content, int i) {
        while (!content.get(i).contains("{")) {
            i++;
        }
        i++;
        // number of open currently open curly-braces
        int open = 1;
        List<String> classContent = new ArrayList<>();
        while (open != 0) {
            for (int j = 0; j < content.get(i).length(); j++) {
                if (content.get(i).charAt(j) == '{') {
                    open++;
                } else if (content.get(i).charAt(j) == '}') {
                    open--;
                }
                if (open == 0) {
                    break;
                }
            }
            classContent.add(content.get(i++));
        }
        String ret = "";
        for (int j = 0; j < classContent.size() - 1; j++) {
            ret += classContent.get(j).replaceFirst("    ", "") + "\n";
        }
        return ret;
    }

    /**
     * takes the content of our file, and the index of the line with a class declaration,
     * and adds all the lines leading up to a "{" to pass them on to the declarationParser
     *
     * @param content: The content of our .java file
     * @param i:       the index of the line, where a "class" appears
     * @return the entire class declaration leading up to a "{"
     */
    private static String getDeclarationLine(List<String> content, int i) {
        String declarationLine = content.get(i);
        while (!content.get(i).contains("{")) {
            declarationLine += content.get(++i);
        }
        return declarationLine;
    }

    /**
     * Takes the declaration of a class and creates the first couple of attributes of our
     * Class-class (easy right?)
     *
     * @param declarationLine: The declaration of out class, containng things like inheritance
     * @return a basic {@link ClassObject} containing all the info from the declaration line
     */
    private static ClassObject parseClassDecLine(String declarationLine) {
        ClassObject classObject = new ClassObject(null, null, SearchObject.AccessModifier.DEFAULT, 0, null);
        String[] lineArgs = declarationLine.split(" ");


        // this is good enough for now ~6am
        if (declarationLine.contains("interface"))
           classObject.setClassType(ClassObject.ClassType.INTERFACE);
        else if (declarationLine.contains("enum"))
	        classObject.setClassType(ClassObject.ClassType.ENUM);
        else classObject.setClassType(ClassObject.ClassType.DEFAULT);
        
        if (declarationLine.contains("abstract"))
            classObject.setInheritanceType(ClassObject.InheritanceType.ABSTRACT);
        else if (declarationLine.contains("final"))
        	classObject.setInheritanceType(ClassObject.InheritanceType.FINAL);
        else classObject.setInheritanceType(ClassObject.InheritanceType.DEFAULT);
        
        if (declarationLine.contains("extends")) {
            classObject.setChild(true);
        }
        if (declarationLine.contains("implements")) {
            classObject.setImplemented(true);
        }

        SearchObject.AccessModifier
		        accessModifier = visibilityParser(declarationLine);
        classObject.setAccessModifier(accessModifier);

        for (int i = 0; i < lineArgs.length; i++) {
            if (lineArgs[i].contains("class") || lineArgs[i].contains("interface")) {
                if (lineArgs[i + 1].contains("<") && lineArgs[i + 1].contains(">")) {
                    classObject.setHasGeneric(lineArgs[i + 1].contains("<") && lineArgs[i + 1].contains(">"));
                    classObject.setName(lineArgs[i + 1].substring(0, lineArgs[i + 1].indexOf("<")));
                } else {
                    classObject.setName(lineArgs[i + 1]);
                }
            }
        }
        return classObject;
    }

    public static SearchObject.AccessModifier visibilityParser(String line) {
        if (line.contains("public")) {
            return SearchObject.AccessModifier.PUBLIC;
        } else if (line.contains("private")) {
            return SearchObject.AccessModifier.PRIVATE;
        } else if (line.contains("protected")) {
            return SearchObject.AccessModifier.PROTECTED;
        }
        return SearchObject.AccessModifier.DEFAULT;
    }

    /**
     * @param fieldString: Insert a single line of a Field (private int p)
     * @param path:        Path of .java
     * @return FieldObject: A FieldObject
     */
    public static FieldObject fieldParser(String fieldString, String path) {
        SearchObject.AccessModifier visibility = visibilityParser(fieldString);
        String[]                    stream     = fieldString.split(" ");
        return new FieldObject(stream[stream.length - 1], visibility, path, 0, stream[stream.length - 2]);
    }

    /**
     * @param method: String of the headerline of a method
     * @param path:   Path of .java
     * @return: MethodObject: A MethodObject with List of Parameters
     */
    public static MethodObject methodParser(String method, String path) {
        SearchObject.AccessModifier visibility = visibilityParser(method);
        String[]                    front      = method.substring(0, method.indexOf('(')).split(" ");
        String[]                    back       = method.substring(method.indexOf('(') + 1, method.indexOf(')')).split(", ");
        MethodObject                result     = null;

        result = new MethodObject(front[front.length - 1], visibility, path, 0, null, method.contains("static"), front[front.length - 2]);

        List<FieldObject> parameters = new ArrayList<>();
        for (String param : back) {
            parameters.add(fieldParser(param, path));
        }
        result.setParameters(parameters);
        return result;
    }
}
