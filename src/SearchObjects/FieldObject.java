package SearchObjects;

public class FieldObject extends SearchObject{
    private String type;

    public FieldObject(String name, byte visibility, String path, String type) {
        super(name, visibility, path, null);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void print() {
        System.out.println(getVisibility() + " " + type + " " + getName());
    }

}
