package FileParser;

import Score.Search;
import SearchObjects.ClassObject;
import SearchObjects.SearchObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileCrawler {
    /**
     * crawler gets handed a path and finds all java files and hands their contents over to
     * the parser, to get parsed into a class
     *
     * @param path: the path of the file/filder we want to look at
     */
    public static void crawl(String path, List<ClassObject> projectClasses) {
        // A java file is atomic, if we find one of those, we hand it over to the parser
        if (path.endsWith(".java")) {
            System.out.println("FILE: " + path);
            projectClasses.add(ClassParser2.fileParser(path, JavaFileReader.readFile(path)));
            return;
        }
        File[] files = new File(path).listFiles();
        if (files == null) {
            return;
        }
        // We now have to recursively crawl through this folder
        for (File f : files) {
            crawl(f.getAbsolutePath(), projectClasses);
        }
    }
}
