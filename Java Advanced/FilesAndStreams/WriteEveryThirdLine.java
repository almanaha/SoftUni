package FilesAndStreams;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "\\paths\\input.txt";
        String outputPath = userDir + "\\paths\\output.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath)))
        {
            String line;
            int counter = 1;

            while ((line = in.readLine()) != null) {
                if (counter++ % 3 == 0) {
                    out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
