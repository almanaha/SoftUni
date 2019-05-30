package FilesAndStreams;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String path = userDir + "\\paths\\input.txt";

        try(FileInputStream files = new FileInputStream(path)) {
            int theOne = files.read();
            while (theOne >= 0){
                System.out.print(Integer.toBinaryString(theOne) + " ");
                theOne = files.read();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
