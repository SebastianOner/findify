package SearchObjects;

import java.util.List;

public class MethodObject extends SearchObject{
    private boolean isStatic;
    private List<FieldObject> parameters;
    private String returnType;

    public MethodObject(String name, String visibility, String path, List<String> content, boolean isStatic, String returnType) {
        super(name, visibility, path, content);
        this.isStatic = isStatic;
        this.returnType = returnType;
    }

    public void setParameters(List<FieldObject> parameters) {
        this.parameters = parameters;
    }

    // TODO: 23-Nov-19 implement Attributes and Getters
}
