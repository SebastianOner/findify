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
        List<String> list = readFile("C:\\Users\\kruge\\Documents\\GitHub\\findify\\src\\CodeBase\\Reptile.java");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Zeile" + (i+1) + ": "+list.get(i));

        }
    }
}
