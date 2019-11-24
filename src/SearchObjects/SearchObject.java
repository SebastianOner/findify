package SearchObjects;

import Score.SemanticWeb;

public abstract class SearchObject {
    static SemanticWeb semanticWeb = new SemanticWeb(new String[][]{
            {"search", "find", "inquire", "request", "explore", "hunt", "choose", "take"},
            {"sort", "arrange", "catalogue", "categorize", "comb", "separate",
                    "sift", "classify", "group", "rank", "order"},
            {"input", "load", "take", "download", "pull", "ask", "request",
                    "query", "get", "specify", "specified"},
            {"output", "print", "write", "respond", "inform", "send", "display",
                    "visualize", "log", "return"},
            {"add", "combine", "merge", "plus", "collect", "append", "prepend",
                    "attach", "push"},
            {"remove", "subtract", "delete", "clear", "get", "take",
                    "get rid of", "erase", "pop"},
            {"iterates", "repeats", "loops", "for every", "while", "for",
                    "every", "always"}, {"filter", "if", "case", "when", "whenever", "consider"},
            {"array", "field", "saves", "data", "matrix", "list"},
            {"math", "add", "plus", "addition", "sub", "subtract", "minus",
                    "multiply", "times", "divide", "division", "power", "root",
                    "square root", "sqrt", "pwr", "logarithm", "log", "round", "absolute",
                    "factorial", "binomial", "calc", "calculate", "compute"}});
    private String name;
    private AccessModifier accessModifier;
    private String path;
    private int line;
    private String[] tags;

    public SearchObject(String name, AccessModifier accessModifier, String path,
                         int line) {
        this.name = name;
        this.accessModifier = accessModifier;
        this.path = path;
        this.line = line;
    }

    //constructor for GUI
    public SearchObject(String name, AccessModifier accessModifier, String[] tags) {
        this.name = name;
        this.accessModifier = accessModifier;
    }

    public SearchObject() {
    } //default Constructor

    //Constructors
    public static String[] split(String string) {
        return string.split("[_, \\-]");
    }

    public static double getStringSimilarity(String[] a, String[] b) {
        String[][] words = a.length < b.length ? new String[][]{a,b} : new String[][]{b,a};
        double product = 1, sum;
        for (String wordA : words[0]) {
            sum = 0;
            for (String wordB : words[1]) {
                sum += semanticWeb.getSimilarity(wordA, wordB);
            }
            product *= sum;
        }
        return product;
    }

    public String getName() {
        return name;
    }

    //Getters
    public void setName(String name) {
        this.name = name;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String[] getTags() {
        return tags;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }

    public String getPath() {
        return path;
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

    public abstract double getSimilarity(SearchObject searchObject);

    public enum AccessModifier {
        PUBLIC, PROTECTED, PRIVATE, DEFAULT
    }
}
