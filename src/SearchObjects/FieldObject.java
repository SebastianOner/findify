package SearchObjects;

public class FieldObject extends SearchObject{
    private String type;

    public FieldObject(String name, byte visibility, String path, int line, String type) {
        super(name, visibility, path, null, line);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return (getVisibility() + " " + type + " " + getName());
    }

}
