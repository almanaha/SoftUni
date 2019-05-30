package FilesAndStreams.Exercises;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "\\sources\\input.txt";
        String pathOut = userDir + "\\sources\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             PrintWriter writer = new PrintWriter(new FileOutputStream(pathOut))) {
            String line;
            while ((line = reader.readLine()) != null) {

                writer.println(line.toUpperCase());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
