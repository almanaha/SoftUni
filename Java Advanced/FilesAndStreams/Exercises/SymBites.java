package FilesAndStreams.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class SymBites {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "\\sources\\input.txt";

        try (BufferedReader input = new BufferedReader(new FileReader(path)))
        {
            String line;
            long sum = 0;
            while ((line = input.readLine()) != null) {

                sum += line.chars().sum();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
