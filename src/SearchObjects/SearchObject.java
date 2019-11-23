package SearchObjects;

public class SearchObject {
    private String name;
    private String visibility;
    private String path;

    public SearchObject(String name, String visibility, String path) {
        this.name = name;
        this.visibility = visibility;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getPath() {
        return path;
    }
}
