package MapsLambdaStreamAPI;

import java.util.*;

public class WordsSynonyms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> pairs = new LinkedHashMap<>();
        int x = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < x; i++) {
            String word = sc.nextLine();
            String synonym = sc.nextLine();

            pairs.putIfAbsent(word, new ArrayList<>());
            pairs.get(word).add(synonym);
        }
        pairs.forEach((w, s) -> {
            System.out.print(w + " - ");
            System.out.println(String.join(", ", s));
        });
    }
}
