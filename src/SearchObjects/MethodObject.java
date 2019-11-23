package SearchObjects;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodObject extends SearchObject {
    private Boolean isStatic;
    private List<FieldObject> parameters;
    private String returnType;

    public MethodObject(String name, AccessModifier visibility, String path, int line,
                        List<String> content, boolean isStatic, String returnType) {
        super(name, visibility, path, content, line);
        this.isStatic = isStatic;
        this.returnType = returnType;
        this.parameters = new ArrayList<FieldObject>();
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
        return "METHOD:\nName: " + getName() + "\nreturn type: " + getReturnType() + "\nvisibility: "
               + getAccessModifier() + "\nisStatic: " + isStatic() + "\n" + parameters.toString();
    }
	@Override public double getSimilarity(SearchObject searchObject){
		MethodObject methodObject = ((MethodObject) searchObject);
		double similarity =
				semanticWeb.getSimilarity(getName(), methodObject.getName());
		if(!getName().equals(methodObject.getName()))
			similarity *= 0.9;
		if(isStatic != methodObject.isStatic)
			similarity *= 0.9;
		if(!returnType.equals(methodObject.returnType))
			similarity *= 0.9;
		//TODO: Change weights
		return similarity;
	}
}
