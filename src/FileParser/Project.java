package FileParser;
import SearchObjects.*;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String path;
    List<ClassObject> javaFileList;

    public Project(String path) {
        javaFileList = new ArrayList<ClassObject>();
    }

    public String getPath() {
        return path;
    }

    public List<ClassObject> getJavaFileList() {
        return javaFileList;
    }

    public void addJavaClass(ClassObject classObject) {
        this.javaFileList.add(classObject);
    }
}
