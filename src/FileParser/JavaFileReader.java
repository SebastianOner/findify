package FileParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaFileReader {
    public static List<String> readFile(String path) {
        ArrayList<String> arr = new ArrayList<String>();
        try
        {
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

    public static void main(String[] args) {
        readFile("~/OneDrive/Repositories/findify/findify/src/CodeBase/Reptile.java");
    }
}
