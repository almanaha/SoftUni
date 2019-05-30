package FilesAndStreams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class SortLines {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "\\paths\\input.txt";
        String outputPath = userDir + "\\paths\\06.SortLinesOutput.txt";

        File file = new File(inputPath);
        Path path = file.toPath();

        try (PrintWriter output = new PrintWriter(new FileOutputStream(outputPath))) {

            Files.readAllLines(path)
                    .stream()
                    .filter(e -> !e.isEmpty())
                    .sorted()
                    .forEach(output::println);

            //Files.write(pathOut, lines);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
