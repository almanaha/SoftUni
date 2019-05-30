package FilesAndStreams.Exercises;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "\\sources\\input.txt";
        String pathOut = userDir + "\\sources\\output.txt";


        // e, i, o, u
        List<Integer> vowels = Arrays.asList(97, 101, 105, 111, 117);
        // '!' ',' '.' '?'
        List<Integer> punctuations = Arrays.asList(33, 44, 46, 63);

        try (InputStream inputStream = new FileInputStream(pathIn);
             PrintWriter writer = new PrintWriter(new FileOutputStream(pathOut))) {
            int sumVowels = 0;
            int sumConsonants = 0;
            int sumPunctuation = 0;
            int oneByte;

            while ((oneByte = inputStream.read()) >= 0) {

                if (oneByte > 32) {

                    if (vowels.contains(oneByte))
                        sumVowels++;
                    else if (punctuations.contains(oneByte))
                        sumPunctuation++;
                    else
                        sumConsonants++;
                }
            }
            writer.printf("Vowels: %d%n", sumVowels);
            writer.printf("Consonants: %d%n", sumConsonants);
            writer.printf("Punctuation: %d%n", sumPunctuation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
