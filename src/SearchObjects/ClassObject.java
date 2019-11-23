package SearchObjects;

import java.util.ArrayList;
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

    public List<FieldObject> getAttributes() {
        return attributes;
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
    public ClassObject(String name, String path, String visibilty, List<String> content) {
        super(name, visibilty, path, content);
        this.classList = new ArrayList<>();
        this.methodList = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }

    public ClassObject(String name, String path, String visibilty,
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
}
