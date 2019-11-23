package FileParser;

import SearchObjects.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing an entire project consisting of many files, and thus consisting of many SearchObjects
 */
public class Project {
    private String path;
    private List<ClassObject> javaFileList;

    public Project(String path) {
        javaFileList = new ArrayList<ClassObject>();
    }

    public void start() {

    }

    public String getPath() {
        return path;
    }

    public List<SearchObject> getJavaFileList() {
        return javaFileList;
    }

    /**
     * Add a Java class to this project structure
     *
     * @param classObject: The Class you want to add to the project
     */
    public void addJavaClass(ClassObject classObject) {
        this.javaFileList.add(classObject);
    }

    /**
     * Printing the java project structure tree-like
     */
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
