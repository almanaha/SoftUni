package FilesAndStreams.Exercises;

import java.io.*;
import java.util.*;

public class MergeTwoFiles {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String one = userDir + "\\sources\\inputOne.txt";
        String two = userDir + "\\sources\\inputTwo.txt";
        String out = userDir + "\\sources\\output.txt";

        Deque<String> lines = new ArrayDeque<>();

        try (BufferedReader readerOne = new BufferedReader(new FileReader(one));
             BufferedReader readerTwo = new BufferedReader(new FileReader(two)))
        {
            String line;
            while ((line = readerOne.readLine()) != null) {
                lines.offer(line);
            }

            while ((line = readerTwo.readLine()) != null) {
                lines.offer(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(out)))
        {
            while (!lines.isEmpty()) {
                writer.println(lines.poll());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
