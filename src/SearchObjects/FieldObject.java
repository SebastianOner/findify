package SearchObjects;

public class FieldObject extends SearchObject {
    private String type;

    public FieldObject(String name, AccessModifier accessModifier, String path,
                       int line,
                       String type) {
        super(name, accessModifier, path, null, line);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return (getAccessModifier() + " " + type + " " + getName());
    }
	
	@Override public double getSimilarity(SearchObject searchObject){
		return 0;
	}
}
