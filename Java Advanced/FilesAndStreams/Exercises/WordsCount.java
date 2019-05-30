package FilesAndStreams.Exercises;

import java.io.*;
import java.util.*;

public class WordsCount {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "\\sources\\words.txt";
        String pathOut = userDir + "\\sources\\output.txt";
        String pathCheck = userDir + "\\sources\\text.txt";


        Map<String, Integer> words = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(pathIn));
             Scanner checker = new Scanner(new File(pathCheck));
             PrintWriter writer = new PrintWriter(new FileOutputStream(pathOut))) {

            Arrays.stream(scanner.nextLine().split("\\s+"))
                    .forEach(e -> words.putIfAbsent(e, 0));

            while (checker.hasNext()) {
                String text = checker.next();
                if (words.containsKey(text)) {
                    words.put(text, words.get(text) + 1);
                }
            }

            words.entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(e -> writer.printf("%s - %d%n", e.getKey(), e.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
