package DefiningClasses.CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<Cat> cats = new ArrayList<>();

        String input;
        while (!"End".equals(input = sc.readLine())) {
            String[] data = input.split("\\s+");
            String breed = data[0];
            String name = data[1];
            double diff = Double.parseDouble(data[2]);

            Cat cat;
            switch (breed) {
                case "Siamese":
                    cat = new Siamese(name, diff);
                    break;
                case "Cymric":
                    cat = new Cymric(name, diff);
                    break;
                default:
                    cat = new StreetExtraordinaire(name, diff);

            }
            cats.add(cat);
        }

        String name = sc.readLine();

        cats.stream()
                .filter(cat -> cat.getName().equals(name))
                .forEach(System.out::println);
    }
}
