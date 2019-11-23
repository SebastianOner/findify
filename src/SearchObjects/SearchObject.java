package SearchObjects;

import java.util.List;

public abstract class SearchObject {
    private String name;
    private String visibility;
    private String path;
    private List<String> content;

    public SearchObject(String name, String visibility, String path, List<String> content) {
        this.name = name;
        this.visibility = visibility;
        this.path = path;
        this.content = content;
    }

    public abstract void print();

    //Getters

    public String getName() {
        return name;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getPath() {
        return path;
    }

    public List<String> getContent() {
        return content;
    }
}
