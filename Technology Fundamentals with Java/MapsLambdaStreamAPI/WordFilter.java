package MapsLambdaStreamAPI;

import java.util.*;

public class WordFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(word -> word.length() % 2 == 0)
                .forEach(System.out::println);
    }
}
