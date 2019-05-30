package FilesAndStreams;

import java.io.*;
import java.util.*;

public class WriteToFile {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String inputFile = userDir + "\\paths\\input.txt";
        String outputFile = userDir + "\\paths\\output.txt";


        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (FileInputStream fileInputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile))
        {
            int oneByte;
            while ((oneByte = fileInputStream.read()) >= 0) {
                if (!symbols.contains((char)oneByte)) {
                    outputStream.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
