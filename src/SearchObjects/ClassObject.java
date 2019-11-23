package SearchObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassObject extends SearchObject {
    private boolean[] classType = new boolean[4];
    private boolean isChild;
    private boolean hasGeneric;
    private boolean isImplemented;
    private List<FieldObject> attributes;
    private List<ClassObject> classList;
    private List<MethodObject> methodList;

    public boolean isChild() {
        return isChild;
    }

    public boolean hasGeneric() {
        return hasGeneric;
    }

    public boolean isImplemented() {
        return isImplemented;
    }

    public List<FieldObject> getAttributes() {
        return attributes;
    }

    public List<ClassObject> getClassList() {
        return classList;
    }

    public List<MethodObject> getMethodList() {
        return methodList;
    }

    /**
     * Setters for Lists of Class-, Method-, and AttributeObject
     * Useful for the ClassParser that will browse the content of
     * the class and find internal classes, methods, and attributes.
     * It will then use the setters.
     */
    public void setClassList(List<ClassObject> classList) {
        this.classList = classList;
    }

    public void setMethodList(List<MethodObject> methodList) {
        this.methodList = methodList;
    }

    public void setAttributes(List<FieldObject> attributes) {
        this.attributes = attributes;
    }

    //Constructor for normal Class without inheritance, generic, implementing Class
    public ClassObject(String name, String path, byte visibilty, List<String> content) {
        super(name, visibilty, path, content);
        this.classList = new ArrayList<>();
        this.methodList = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }

    public ClassObject(String name, String path, byte visibilty,
                       boolean isChild, boolean hasGeneric, List<String> content) {
        super(name, visibilty, path, content);
        this.isChild = isChild;
        this.hasGeneric = hasGeneric;
        this.classList = new ArrayList<>();
        this.methodList = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }

    /**
     *
     * @param type boolean array with 4 Elements: Interface, Abstract, ENUM, Final
     */
    public void setClassType(boolean[] type) {
        if(type.length != 4 || type == null) {
            System.out.println("Not valid ClassType");
            return;
        }
        this.classType = type;
    }

    public void print() {
        System.out.println("Class " + getName());
        for(ClassObject c: classList) {
            c.print();
            System.out.println();
        }
        for (FieldObject f: attributes) {
            f.print();
            System.out.println();
        }
        for (MethodObject m: methodList) {
            m.print();
            System.out.println();
        }
    }

    public boolean[] getClassType() {
        return classType;
    }

    public boolean isHasGeneric() {
        return hasGeneric;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    public void setHasGeneric(boolean hasGeneric) {
        this.hasGeneric = hasGeneric;
    }

    public void setImplemented(boolean implemented) {
        isImplemented = implemented;
    }

    @Override
    public String toString() {
        return "name: "+getName() + "\nvisibility: " + getVisibility() +"\nisChild: " + isChild + "\nisImplemented: " +
                isImplemented + "\nHas Generics: " + hasGeneric + "\n" + Arrays.toString(classType) + "\n" +
                getContent();
    }
}
