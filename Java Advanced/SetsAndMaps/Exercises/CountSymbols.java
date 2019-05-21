package SetsAndMaps.Exercises;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> symbols = new TreeMap<>();

        String[] data = sc.nextLine().split("");
        if (data.length == 1 && "".equals(data[0])){
            return;
        }
        for (String entry : data) {
            symbols.putIfAbsent(entry, 0);
            symbols.put(entry, symbols.get(entry) + 1);
        }
        symbols.forEach((key, value) -> System.out.printf("%s: %d time/s%n", key, value));
    }
}
