package FileParser;

import SearchObjects.ClassObject;
import SearchObjects.SearchObject;

import java.util.ArrayList;
import java.util.List;

public class ClassParser {
    static ArrayList<SearchObject> parse(String path, List<String> content) {
        ArrayList<SearchObject> objects = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).contains("class") || content.get(i).contains("enum")) {
                // passing path as param is good enough for now
                parseClassDecLine(path, content.get(i));
            }
        }
        return null;
    }

    private static ClassObject parseClassDecLine(String path, String declarationLine) {
        ClassObject classObject = new ClassObject(null, null, (byte) 0, null);
        String[] lineArgs = declarationLine.split(" ");
        classObject.setPath(path);
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
                classObject.setHasGeneric(lineArgs[i+1].contains("<") && lineArgs[i+1].contains(">"));
                classObject.setName(lineArgs[i+1].substring(0, lineArgs[i+1].indexOf("<")));
            } else {
                classObject.setName(lineArgs[i+1]);
            }
        }
        return classObject;
    }
}
