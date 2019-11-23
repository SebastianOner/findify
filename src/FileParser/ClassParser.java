package FileParser;

import SearchObjects.ClassObject;
import SearchObjects.SearchObject;

import java.util.ArrayList;
import java.util.List;

public class ClassParser {
    static ArrayList<SearchObject> parse(String path, List<String> content) {
        ArrayList<SearchObject> objects = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).contains("class")) {
                // passing path as param is good enough for now
                parseClassDecLine(path, content.get(i));
            }
        }
        return null;
    }

    

    private static ClassObject parseClassDecLine(String path, String s) {
        ClassObject classObject = new ClassObject("", "", "", null);
        String[] lineArgs = s.split(" ");
        boolean[] classTypeArr = new boolean[4];


        // this is good enough for now ~6am
        if (s.contains("interface")) {
            classTypeArr[0] = true;
        }
        if (s.contains("abstract")) {
            classTypeArr[1] = true;
        }
        if (s.contains("enum")) {
            classTypeArr[2] = true;
        }
        if (s.contains("final")) {
            classTypeArr[3] = true;
        }
        classObject.setClassType(classTypeArr);
        if (s.contains("extends")) {
            classObject.setChild(true);
        }
        if (s.contains("implements")) {
            classObject.setImplemented(true);
        }

        classObject.setPath(path);
        if (s.contains("public")) {
            classObject.setVisibility("public");
        } else if (s.contains("private")) {
            classObject.setVisibility("private");
        } else if (s.contains("protected")) {
            classObject.setVisibility("protected");
        }

        for (int i = 0; i < lineArgs.length; i++) {
            if (lineArgs[i].contains("class") || lineArgs[i].contains("interface")) {
                classObject.setHasGeneric(lineArgs[i+1].contains("<") && lineArgs[i+1].contains(">"));
                classObject.setName(lineArgs[i+1].substring(0, lineArgs[i+1].indexOf("<")));
            } else {
                classObject.setName(lineArgs[i+1]);
            }
        }
        return classObject;
    }
}
