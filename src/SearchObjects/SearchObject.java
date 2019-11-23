package SearchObjects;

import java.util.List;

public abstract class SearchObject {
	public static enum AccessModifier{
		PUBLIC, PROTECTED, PRIVATE, DEFAULT;
	}
    private String         name;
    private AccessModifier accessModifier;
    private String         path;
    private int            line;

    public SearchObject(String name, AccessModifier accessModifier, String path,
                        List<String> content, int line) {
	    this.name           = name;
	    this.accessModifier = accessModifier;
	    this.path           = path;
	    this.line           = line;
    }

    //Getters

    public String getName() {
        return name;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
	    this.accessModifier = accessModifier;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
}
