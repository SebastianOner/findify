package SearchObjects;

public class FieldObject extends SearchObject{
	private String type;
	
	public FieldObject(String name, AccessModifier accessModifier, String path,
	                   int line, String type){
		super(name, accessModifier, path, null, line);
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public String toString(){
		return (getAccessModifier() + " " + type + " " + getName());
	}
	
	@Override public double getSimilarity(SearchObject searchObject){
		FieldObject fieldObject = ((FieldObject)searchObject);
		double similarity =
				semanticWeb.getSimilarity(getName(), fieldObject.getName());
		if(!getName().equals(fieldObject.getName()))
			similarity *= 0.9;
		if(getAccessModifier() != fieldObject.getAccessModifier())
			similarity *= 0.9;
		if(getType() != fieldObject.getType())
			similarity *= 0.9;
		//TODO: Change weights
		return similarity;
	}
}
