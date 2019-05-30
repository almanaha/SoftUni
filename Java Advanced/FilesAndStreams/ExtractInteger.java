package FilesAndStreams;

import java.io.*;
import java.util.Scanner;

public class ExtractInteger {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String path = userDir + "\\paths\\input.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(path)))
        {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt());
                }
                scanner.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
