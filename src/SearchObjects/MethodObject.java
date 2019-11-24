package SearchObjects;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodObject extends SearchObject {
    private Boolean isStatic;
    private List<FieldObject> parameters;
    private String returnType;

    public MethodObject(String name, AccessModifier visibility, String path,
                        int line, Boolean isStatic,
                        String returnType) {
        super(name, visibility, path, line);
        this.isStatic = isStatic;
        this.returnType = returnType;
        this.parameters = new ArrayList<FieldObject>();
    }

    //constructor for GUI
    public MethodObject(String name, AccessModifier visibility, Boolean isStatic,
                        String returnType, List<FieldObject> parameters, String[] tags) {
        super(name, visibility, tags);
        this.isStatic = isStatic;
        this.returnType = returnType;
        this.parameters = parameters;
    }

    public void setParameters(List<FieldObject> parameters) {
        this.parameters = parameters;
    }

    public void setStatic(Boolean aStatic) {
        isStatic = aStatic;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public Boolean isStatic() {
        return isStatic;
    }

    public String getReturnType() {
        return returnType;
    }

    public List<FieldObject> getParameters() {
        return parameters;
    }

    // TODO: 23-Nov-19 implement Attributes and Getters

    public String toString() {
        return "METHOD: " + getName() + "\nreturn type: " +
                getReturnType() + "\nvisibility: " + getAccessModifier() +
                "\nisStatic: " + isStatic() + "\n" + parameters.toString();
    }

    @Override
    public double getSimilarity(SearchObject searchObject) {
        MethodObject methodObject = ((MethodObject) searchObject);
        double similarity = 1;
        if (getName() != null)
            similarity *= semanticWeb.getSimilarity(getName(), methodObject.getName());

        if (isStatic != null)
            if (methodObject.isStatic != null &&
                    isStatic == methodObject.isStatic)
                similarity *= 0.9;
            else similarity *= 0.1;

        if (returnType != null)
            if (methodObject.returnType != null &&
                    returnType.equals(methodObject.returnType))
                similarity *= 0.9;
            else similarity *= 0.1;
        return similarity;
    }

}
