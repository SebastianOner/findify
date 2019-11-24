package SearchObjects;

public class FieldObject extends SearchObject {
    private String type;

    public FieldObject(String name, AccessModifier accessModifier, String path,
                       int line, String type) {
        super(name, accessModifier, path, line);
        this.type = type;
    }

    public FieldObject(String type) {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return (getAccessModifier() + " " + type + " " + getName());
    }

    @Override
    public double getSimilarity(SearchObject searchObject) {
        FieldObject fieldObject = ((FieldObject) searchObject);
        double similarity = 1;
        if (getName() != null)
            similarity *= semanticWeb.getSimilarity(getName(), fieldObject.getName());

        if (getAccessModifier() != null)
            if (fieldObject.getAccessModifier() != null &&
                    getAccessModifier() == fieldObject.getAccessModifier())
                similarity *= 0.9;
            else similarity *= 0.1;

        if (getType() != null)
            if (fieldObject.getType() != null &&
                    getType() == fieldObject.getType())
                similarity *= 0.9;
            else similarity *= 0.1;
        //TODO: Change weights
        return similarity;
    }
}
