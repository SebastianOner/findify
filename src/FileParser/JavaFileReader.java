package FileParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JavaFileReader {

    public static String readFile(String path) {
        File file = new File((path));
        FileInputStream fis = null;
        StringBuilder fileString = new StringBuilder();

        try {
            fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                fileString.append((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return fileString.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                readFile("C:\\Users\\kruge\\Documents\\GitHub\\findify\\src\\CodeBase\\Crocodile.java")
        );
    }
}
