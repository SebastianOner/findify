package FileParser;

import SearchObjects.*;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String path;
    List<SearchObject> javaFileList;

    public Project(String path) {
        javaFileList = new ArrayList<SearchObject>();
    }

    public String getPath() {
        return path;
    }

    public List<SearchObject> getJavaFileList() {
        return javaFileList;
    }

    public void addJavaClass(ClassObject classObject) {
        this.javaFileList.add(classObject);
    }

    public void printTreeStructure() {
        int i = 1;
        for (SearchObject c : javaFileList) {
            System.out.print("File" + i);
            c.toString();
            i++;
            System.out.println();
        }
    }
}
