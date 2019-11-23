package FileParser;

import java.io.File;

public class FileCrawler {
    /**
     * crawler gets handed a path and finds all java files and hands their contents over to
     * the parser, to get parsed into a class
     *
     * @param path: the path of the file/filder we want to look at
     */
    static void crawl(String path) {
        if (path.endsWith(".java")) {
            // TODO: 23.11.19 Hand over java file to fileParser
            return;
        }
        File[] files = new File(path).listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            crawl(f.getAbsolutePath());
        }
    }
}
