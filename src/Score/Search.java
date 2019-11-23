package Score;

import FileParser.Project;
import SearchObjects.ClassObject;
import SearchObjects.MethodObject;
import SearchObjects.SearchObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

final public class Search{
	private static PriorityHeap<SearchObject> priorityHeap;
	
	public static ArrayList<SearchObject> getBests(Project project,
	                                          SearchObject request){
		List<SearchObject> searchObjects = project.getJavaFileList();
		searchObjects.forEach(o -> traverse(o, request));
		ArrayList<SearchObject> bests = new ArrayList<>();
		for(int i = 0; i < 5 && !priorityHeap.isEmpty(); ++i)
			bests.add(priorityHeap.dequeueMax().getObject());
		return bests;
	}
	
	private static void traverse(SearchObject searchObject,
	                             SearchObject request){
		if(request.getClass() == searchObject.getClass()){
			priorityHeap
					.enqueue(searchObject, request.getSimilarity(searchObject));
		}
		//TODO: Beautify following code.
		if(searchObject instanceof ClassObject){
			ClassObject classObject = ((ClassObject)searchObject);
			classObject.getAttributes().forEach(o -> traverse(o, request));
			classObject.getClasses().forEach(o -> traverse(o, request));
			classObject.getMethods().forEach(o -> traverse(o, request));
		}
		if(searchObject instanceof MethodObject){
			MethodObject methodObject = ((MethodObject)searchObject);
			methodObject.getParameters().forEach(o -> traverse(request, o));
		}
	}
}
