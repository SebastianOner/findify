package SearchObjects;

import java.util.List;

public class ClassObject extends SearchObject {
    private String name;
    private String path;
    private String visibilty;
    private String classType;
    private boolean isChild;
    private boolean hasGeneric;
    private List<AttributeObject> attributes;
    private List<String> content;


    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getVisibilty() {
        return visibilty;
    }

    public String getClassType() {
        return classType;
    }

    public boolean isChild() {
        return isChild;
    }

    public boolean isHasGeneric() {
        return hasGeneric;
    }

    public List<AttributeObject> getAttributes() {
        return attributes;
    }

    public List<String> getContent() {
        return content;
    }

    public ClassObject(String name, String path, String visibilty, List<String> content) {
        super(name, visibilty, path);
        this.content = content;
    }

    public ClassObject(String name, String path, String visibilty, String classType,
                       boolean isChild, boolean hasGeneric, List<AttributeObject> attributes,
                       List<String> content) {
        super(name, visibilty, path);
        this.classType = classType;
        this.isChild = isChild;
        this.hasGeneric = hasGeneric;
        this.attributes = attributes;
        this.content = content;
    }
}
