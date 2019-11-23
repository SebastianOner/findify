package SearchObjects;

import java.util.List;

public abstract class SearchObject {
    private String name;
    private byte visibility;
    private String path;
    private List<String> content;

    public SearchObject(String name, byte visibility, String path, List<String> content) {
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

    public byte getVisibility() {
        return visibility;
    }

    public String getPath() {
        return path;
    }

    public List<String> getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVisibility(byte visibility) {
        this.visibility = visibility;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
