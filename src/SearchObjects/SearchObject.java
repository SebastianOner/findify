package SearchObjects;

import java.util.List;

public abstract class SearchObject {
    private String name;
    private byte visibility;
    private String path;
    private int line;

    public SearchObject(String name, byte visibility, String path, List<String> content, int line) {
        this.name = name;
        this.visibility = visibility;
        this.path = path;
        this.line = line;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setVisibility(byte visibility) {
        this.visibility = visibility;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
}
