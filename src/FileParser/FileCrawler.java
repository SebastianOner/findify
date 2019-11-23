package FileParser;

import java.io.File;

public class FileCrawler {
    /**
     * crawler gets handed a path and finds all java files and hands their contents over to
     * the parser, to get parsed into a class
     *
     * @param path: the path of the file/filder we want to look at
     */
    public static void crawl(String path) {
        if (path.endsWith(".java")) {
            System.out.println("FILE: " + path);
            ClassParser.parse(path, JavaFileReader.readFile(path));
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
