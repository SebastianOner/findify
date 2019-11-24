package FileParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaFileReader {

    /**
     * Reading a java file into a String-List, that you can parse easily
     *
     * @param path: the path of the .java file
     * @return ArrayList over the lines of the file, thus preserving the line number
     */
    public static List<String> readFile(String path) {
        ArrayList<String> arr = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
