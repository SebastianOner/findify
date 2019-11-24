package SearchObjects;

import Score.SemanticWeb;

import java.util.List;

public abstract class SearchObject {
    static SemanticWeb semanticWeb = new SemanticWeb(new String[][]{
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
    private String name;
    private AccessModifier accessModifier;
    private String path;
    private int line;

    public SearchObject(String name, AccessModifier accessModifier, String path,
                        List<String> content, int line) {
        this.name = name;
        this.accessModifier = accessModifier;
        this.path = path;
        this.line = line;
    }

    public SearchObject(String name, AccessModifier accessModifier) {
        this.name = name;
        this.accessModifier = accessModifier;
    }

    public SearchObject() {
    } //default Constructor

    //Constructors
    private static String[] split(String string) {
        return string.split("_|,| |-");
    }

    public static double getStringSimilarity(String a, String b) {
        String[][] words =
                a.length() < b.length() ? new String[][]{split(a), split(b)} :
                        new String[][]{split(b), split(a)};
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
