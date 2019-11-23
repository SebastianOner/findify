package SearchObjects;

import java.util.ArrayList;
import java.util.List;

public class MethodObject extends SearchObject{
    private boolean isStatic;
    private List<FieldObject> parameters;
    private String returnType;

    public MethodObject(String name, byte visibility, String path, int line, List<String> content, boolean isStatic, String returnType) {
        super(name, visibility, path, content, line);
        this.isStatic = isStatic;
        this.returnType = returnType;
        this.parameters = new ArrayList<FieldObject>();
    }

    public void setParameters(List<FieldObject> parameters) {
        this.parameters = parameters;
    }

    public List<FieldObject> getParameters() {
        return parameters;
    }

    // TODO: 23-Nov-19 implement Attributes and Getters

    public void print() {
        System.out.print(getName()+"(");
        parameters.get(0).print();
        for(int i = 1; i < parameters.size(); i++) {
            System.out.print(", ");
            parameters.get(i).print();
        }
        System.out.println(")");
    }
}
