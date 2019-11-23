package FileParser;

import SearchObjects.ClassObject;
import SearchObjects.SearchObject;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ClassParser {
    static ArrayList<SearchObject> parse(String path, List<String> content) {
        ArrayList<SearchObject> objects = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            if ((content.get(i).contains("class ") || content.get(i).contains("interface"))&& realClass(content.get(i))) {
                ClassObject classObject = parseClassDecLine(getDeclarationLine(content, i));
                classObject.setPath(path);
                getContent(content, i);
                System.out.println(classObject.toString());
                extractContent(getContent(content, i), classObject);
            }
        }
        return null;
    }

    /**
     * Checks whether or not the String " class " here actually belongs to the program or to a comment
     *
     * @param string: the line to be checked for comments
     * @return true if the keyword class is outside of comments, else false
     */
    private static boolean realClass(String string) {
        if (!string.contains("//") && !string.contains("*") && !string.contains("/*") && !string.contains("/**") ) {
            return true;
        }
        // else we have to determine whether the keyword itself is commented or legit
        string = string.substring(0, string.indexOf(" class "));
        if (!string.contains("//") && !string.contains("*") && !string.contains("/*") && !string.contains("/**") ) {
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
     * @param i: index of the start of the class
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
        for (int j = 0; j < classContent.size()-1; j++) {
            ret += classContent.get(j).replaceFirst("    ", "") + "\n";
        }
        return ret;
    }

    /**
     * takes the content of our file, and the index of the line with a class declaration,
     * and adds all the lines leading up to a "{" to pass them on to the declarationParser
     *
     * @param content: The content of our .java file
     * @param i: the index of the line, where a "class" appears
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
        ClassObject classObject = new ClassObject(null, null, (byte) 0, null);
        String[] lineArgs = declarationLine.split(" ");
        boolean[] classTypeArr = new boolean[4];


        // this is good enough for now ~6am
        if (declarationLine.contains("interface")) {
            classTypeArr[0] = true;
        }
        if (declarationLine.contains("abstract")) {
            classTypeArr[1] = true;
        }
        if (declarationLine.contains("enum")) {
            classTypeArr[2] = true;
        }
        if (declarationLine.contains("final")) {
            classTypeArr[3] = true;
        }
        classObject.setClassType(classTypeArr);
        if (declarationLine.contains("extends")) {
            classObject.setChild(true);
        }
        if (declarationLine.contains("implements")) {
            classObject.setImplemented(true);
        }

        if (declarationLine.contains("public")) {
            classObject.setVisibility((byte) 1);
        } else if (declarationLine.contains("private")) {
            classObject.setVisibility((byte) 2);
        } else if (declarationLine.contains("protected")) {
            classObject.setVisibility((byte) 3);
        } else {
            classObject.setVisibility((byte) 0);
        }

        for (int i = 0; i < lineArgs.length; i++) {
            if (lineArgs[i].contains("class") || lineArgs[i].contains("interface")) {
                if (lineArgs[i+1].contains("<") && lineArgs[i+1].contains(">")) {
                    classObject.setHasGeneric(lineArgs[i+1].contains("<") && lineArgs[i+1].contains(">"));
                    classObject.setName(lineArgs[i+1].substring(0, lineArgs[i+1].indexOf("<")));
                } else {
                    classObject.setName(lineArgs[i+1]);
                }
            }
        }
        return classObject;
    }

    public static void main(String[] args) {
        parse("/home/sebastian/OneDrive/Repositories/findify/findify/src/CodeBase/Crocodile.java", JavaFileReader.readFile("/home/sebastian/OneDrive/Repositories/findify/findify/src/CodeBase/Crocodile.java"));
    }
}
