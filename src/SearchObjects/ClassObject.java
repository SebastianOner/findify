package SearchObjects;

import java.util.ArrayList;
import java.util.List;

public class ClassObject extends SearchObject {
    private Boolean isChild;
    private Boolean hasGeneric;
    private Boolean isImplemented;
    private List<FieldObject> attributes;
    private List<ClassObject> classes;
    private List<MethodObject> methods;
    private InheritanceType inheritanceType;
    private ClassType classType;

    //Constructor for normal Class without inheritance, generic, implementing
    // Class
    public ClassObject(String name, String path, AccessModifier accessModifier,
                       int line, List<String> content) {
        super(name, accessModifier, path, content, line);
        this.classes = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }

    public ClassObject(String name, AccessModifier accessModifier,
                       Boolean isChild, Boolean hasGeneric,
                       Boolean isImplemented, InheritanceType inheritanceType,
                       ClassType classType, List<FieldObject> attributes) {
        super(name, accessModifier);
        this.isChild = isChild;
        this.hasGeneric = hasGeneric;
        this.isImplemented = isImplemented;
        this.inheritanceType = inheritanceType;
        this.classType = classType;
        this.attributes = attributes;
    }

    public ClassObject(String name, String path, AccessModifier accessModifier,
                       int line, Boolean isChild, Boolean hasGeneric,
                       List<String> content) {
        super(name, accessModifier, path, content, line);
        this.isChild = isChild;
        this.hasGeneric = hasGeneric;
        this.classes = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }

    public Boolean isChild() {
        return isChild;
    }

    public Boolean hasGeneric() {
        return hasGeneric;
    }

    public Boolean isImplemented() {
        return isImplemented;
    }

    public List<FieldObject> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<FieldObject> attributes) {
        this.attributes = attributes;
    }

    public List<ClassObject> getClasses() {
        return classes;
    }

    /**
     * Setters for Lists of Class-, Method-, and AttributeObject
     * Useful for the ClassParser that will browse the content of
     * the class and find internal classes, methods, and attributes.
     * It will then use the setters.
     */
    public void setClasses(List<ClassObject> classes) {
        this.classes = classes;
    }

    public List<MethodObject> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodObject> methods) {
        this.methods = methods;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public InheritanceType getInheritanceType() {
        return inheritanceType;
    }

    public void setInheritanceType(InheritanceType inheritanceType) {
        this.inheritanceType = inheritanceType;
    }

    public Boolean isHasGeneric() {
        return hasGeneric;
    }

    public void setChild(Boolean child) {
        isChild = child;
    }

    public void setHasGeneric(Boolean hasGeneric) {
        this.hasGeneric = hasGeneric;
    }

    public void setImplemented(Boolean implemented) {
        isImplemented = implemented;
    }

    @Override
    public String toString() {
        return "CLASS: " + getName() + "\nvisibility: " +
                getAccessModifier() + "\nisChild: " + isChild +
                "\nisImplemented: " + isImplemented + "\nHas Generics: " +
                hasGeneric + "\n" + classType + "\n" + inheritanceType + "\n" +
                getAttributes().toString() + "\n" + getMethods().toString();
                //"\n" + getClasses().toString();
    }

    @Override
    public double getSimilarity(SearchObject searchObject) {
        ClassObject classObject = ((ClassObject) searchObject);
        double similarity =
                semanticWeb.getSimilarity(getName(), classObject.getName());
        //TODO: Beautify following code
        if (getName() != null && classObject.getName() != null &&
                !getName().equals(classObject.getName()))
            similarity *= 0.9;
        if (getAccessModifier() != null &&
                classObject.getAccessModifier() == null &&
                getAccessModifier() != classObject.getAccessModifier())
            similarity *= 0.9;
        if (isChild != null && classObject.isChild != null &&
                isChild != classObject.isChild)
            similarity *= 0.9;
        if (hasGeneric != null && classObject.hasGeneric != null &&
                hasGeneric != classObject.hasGeneric)
            similarity *= 0.9;
        if (getInheritanceType() != null &&
                classObject.getInheritanceType() != null &&
                getInheritanceType() != classObject.getInheritanceType())
            similarity *= 0.9;
        if (getClassType() != null && classObject.getClassType() != null &&
                getClassType() != classObject.getClassType()) {
            similarity *= 0.9;
        }
        //TODO: Change weights
        return similarity;
    }

    public enum InheritanceType {
        ABSTRACT, FINAL, DEFAULT
    }

    public enum ClassType {
        ENUM, INTERFACE, DEFAULT
    }
}