package Score;

import FileParser.Project;
import GUI.GUIClassInstance;
import SearchObjects.ClassObject;
import SearchObjects.SearchObject;

import java.util.List;

final public class Search{
	private static PriorityHeap<SearchObject> priorityHeap;
	
//	public static SearchObject[] getBest(Project project, SearchObject request){
//		List<SearchObject> searchObjects = project.getJavaFileList();
//		for(SearchObject searchObject : searchObjects){
//			if(request.getClass() == searchObject.getClass()){
//				priorityHeap.enqueue(searchObject,
//				                     request.getSimilarity(searchObject));
//			}
//
//		}
//
//	}
//
//	private static void traverse(List<SearchObject> searchObjects,
//	                             GUIClassInstance request){
//		for(SearchObject searchObject : searchObjects){
//			if(searchObject instanceof ClassObject && request.)
//		}
//
//	}
//}
