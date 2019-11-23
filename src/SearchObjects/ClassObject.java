package SearchObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassObject extends SearchObject{
	public enum InheritanceType{
		ABSTRACT, FINAL, DEFAULT
	}
	public enum ClassType{
		ENUM, INTERFACE, DEFAULT
	}
	private boolean            isChild;
	private boolean            hasGeneric;
	private boolean            isImplemented;
	private List<FieldObject>  attributes;
	private List<ClassObject>  classes;
	private List<MethodObject> methods;
	private InheritanceType    inheritanceType;
	private ClassType          classType;
	
	public boolean isChild(){
		return isChild;
	}
	
	public boolean hasGeneric(){
		return hasGeneric;
	}
	
	public boolean isImplemented(){
		return isImplemented;
	}
	
	public List<FieldObject> getAttributes(){
		return attributes;
	}
	
	public List<ClassObject> getClasses(){
		return classes;
	}
	
	public List<MethodObject> getMethods(){
		return methods;
	}
	
	/**
	 Setters for Lists of Class-, Method-, and AttributeObject
	 Useful for the ClassParser that will browse the content of
	 the class and find internal classes, methods, and attributes.
	 It will then use the setters.
	 */
	public void setClasses(List<ClassObject> classes){
		this.classes = classes;
	}
	
	public void setMethods(List<MethodObject> methods){
		this.methods = methods;
	}
	
	public void setAttributes(List<FieldObject> attributes){
		this.attributes = attributes;
	}
	
	//Constructor for normal Class without inheritance, generic, implementing Class
	public ClassObject(String name, String path, AccessModifier accessModifier,
	                   int line, List<String> content){
		super(name, accessModifier, path, content, line);
		this.classes    = new ArrayList<>();
		this.methods    = new ArrayList<>();
		this.attributes = new ArrayList<>();
	}
	
	public ClassObject(String name, String path, AccessModifier accessModifier,
	                   int line, boolean isChild, boolean hasGeneric,
	                   List<String> content){
		super(name, accessModifier, path, content, line);
		this.isChild    = isChild;
		this.hasGeneric = hasGeneric;
		this.classes    = new ArrayList<>();
		this.methods    = new ArrayList<>();
		this.attributes = new ArrayList<>();
	}
	
	public void setClassType(ClassType classType){
		this.classType = classType;
	}
	public void setInheritanceType(InheritanceType inheritanceType){
		this.inheritanceType = inheritanceType;
	}
	public ClassType getClassType(){
		return classType;
	}
	
	public InheritanceType getInheritanceType(){
		return inheritanceType;
	}
	
	public boolean isHasGeneric(){
		return hasGeneric;
	}
	
	public void setChild(boolean child){
		isChild = child;
	}
	
	public void setHasGeneric(boolean hasGeneric){
		this.hasGeneric = hasGeneric;
	}
	
	public void setImplemented(boolean implemented){
		isImplemented = implemented;
	}
	
	@Override public String toString(){
		return "CLASS:\nname: " + getName() + "\nvisibility: " +
		       getAccessModifier() + "\nisChild: " + isChild +
		       "\nisImplemented: " + isImplemented + "\nHas Generics: " +
		       hasGeneric + "\n" + classType + "\n" + inheritanceType + "\n" +
		       getAttributes().toString() + "\n" + getMethods().toString() +
		       "\n" + getClasses().toString();
	}
	@Override public double getSimilarity(SearchObject searchObject){
		double similarity = 1;
		ClassObject classObject = ((ClassObject) searchObject);
		if(isChild != classObject.isChild)
			similarity *= 0.9;
		if(hasGeneric != classObject.hasGeneric)
			similarity *= 0.9;
		if(inheritanceType != classObject.inheritanceType)
			similarity *= 0.9;
		if(classType != classObject.classType) {
			similarity *= 0.9;
		}
		//TODO: Add further comparisons
		return similarity;
	}
}
