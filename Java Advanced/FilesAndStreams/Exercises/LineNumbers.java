package FilesAndStreams.Exercises;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "\\sources\\inputLineNumbers.txt";
        String pathOut = userDir + "\\sources\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             FileWriter writer = new FileWriter(pathOut)) {
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {

                writer.write(String.format("%d. %s%n", count++, line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
