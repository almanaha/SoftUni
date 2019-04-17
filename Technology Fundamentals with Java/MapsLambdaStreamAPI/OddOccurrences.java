package MapsLambdaStreamAPI;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().toLowerCase().split("\\s+");
        Map<String, Integer> words = new LinkedHashMap<>();

        for (String w : data) {
            if (words.containsKey(w)) {
                words.put(w, words.get(w) + 1);
            } else {
                words.put(w, 1);
            }
        }
        List<String> odd = new ArrayList<>();
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            if (word.getValue() % 2 == 1) {
                odd.add(word.getKey());
            }
        }
        System.out.println(String.join(", ",odd));
    }
}
