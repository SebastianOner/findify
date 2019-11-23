package SearchObjects;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodObject extends SearchObject {
    private boolean isStatic;
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

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public boolean isStatic() {
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
		double similarity = 1;
		if(isStatic != methodObject.isStatic)
			similarity *= 0.9;
		if(!returnType.equals(methodObject.returnType))
			similarity *= 0.9;
		//TODO: Add further comparisons
		return similarity;
	}
}
