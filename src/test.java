public class test{
	public static void main(String[] args){
		SemanticWeb semanticWeb = new SemanticWeb(new String[][]{
				{"search", "find", "inquire", "request", "explore", "hunt"},
				{"sort", "arrange", "catalogue", "categorize", "comb",
				 "separate", "sift", "classify", "group", "rank", "order"},
				{"input", "load", "take", "download", "pull", "ask", "request",
				 "query"},
				{"output", "print", "write", "respond", "inform", "send",
				 "display", "visualize"},
				{"add", "combine", "merge", "plus", "collect", "append",
				 "prepend", "attach", "push"},
				{"remove", "subtract", "delete", "clear",
				 "get" + " " + "rid of", "erase", "pop"},
				{"iterates", "repeats", "loops", "for every", "while", "for",
				 "every"}, {"filter", "if", "case", "when", "whenever"},
				{"array", "field", "saves", "data", "matrix"},
				{"math", "add", "plus", "addition", "sub", "subtract", "minus",
				 "multiply", "times", "divide", "division", "power", "root",
				 "square root", "logarithm", "round", "absolute", "factorial",
				 "binomial"}});
		String[] synonyms = semanticWeb.getSynonyms("addition");
		for(String synonym : synonyms) {
			System.out.println(synonym);
		}
	}
}
