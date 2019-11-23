package Score;

import FileParser.Project;
import GUI.GUIClassInstance;
import SearchObjects.ClassObject;
import SearchObjects.SearchObject;

import java.util.List;

final public class Search{
	
	private static SemanticWeb semanticWeb = new SemanticWeb(new String[][]{
			{"search", "find", "inquire", "request", "explore", "hunt"},
			{"sort", "arrange", "catalogue", "categorize", "comb", "separate",
			 "sift", "classify", "group", "rank", "order"},
			{"input", "load", "take", "download", "pull", "ask", "request",
			 "query"},
			{"output", "print", "write", "respond", "inform", "send", "display",
			 "visualize", "log"},
			{"add", "combine", "merge", "plus", "collect", "append", "prepend",
			 "attach", "push"},
			{"remove", "subtract", "delete", "clear", "get", "take",
			 "get rid of", "erase", "pop"},
			{"iterates", "repeats", "loops", "for every", "while", "for",
			 "every"}, {"filter", "if", "case", "when", "whenever"},
			{"array", "field", "saves", "data", "matrix"},
			{"math", "add", "plus", "addition", "sub", "subtract", "minus",
			 "multiply", "times", "divide", "division", "power", "root",
			 "square root", "logarithm", "log", "round", "absolute",
			 "factorial", "binomial"}});
	
	private static PriorityHeap<SearchObject> priorityHeap;
	
	private static String[] split(String string){
		return string.split("_|,| |-");
	}
//	public static double getSimilarity(String a, String b){
//		String[][] words =
//				a.length() < b.length() ? new String[][]{split(a), split(b)} :
//				new String[][]{split(b), split(a)};
//		double product = 1, sum;
//		for(String wordA : words[0]){
//			sum = 0;
//			for(String wordB : words[1]){
//				sum += semanticWeb.getSimilarity(wordA, wordB);
//			}
//			product *= sum;
//		}
//		return product;
//	}
//
//	public static SearchObject[] getBest(Project project,
//	                                     SearchObject request){
//		List<SearchObject> searchObjects = project.getJavaFileList();
//		for(SearchObject searchObject : searchObjects) {
//			if(request.getClass() == searchObject.getClass()) {
//				priorityHeap.enqueue(searchObject, request.getSimilarity());
//			}
//		}
//
//	}
//
//	private static void traverse(List<SearchObject> searchObjects,
//	                             GUIClassInstance request){
//		for(SearchObject searchObject : searchObjects) {
//			if(searchObject instanceof ClassObject && request.)
//		}
//
//	}
}
