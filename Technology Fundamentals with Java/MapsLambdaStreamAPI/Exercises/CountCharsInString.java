package MapsLambdaStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        Map<Character, Integer> letters = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char let = text.charAt(i);
            if (let != ' ') {
                letters.putIfAbsent(let, 0);
                letters.put(let, letters.get(let) + 1);
            }
        }

        letters.forEach((key, value) -> System.out.println(key + " -> " + value));

    }
}
