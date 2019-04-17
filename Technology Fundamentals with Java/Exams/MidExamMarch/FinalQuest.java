package Exams.MidExamMarch;

import java.util.*;
import java.util.stream.Collectors;

public class FinalQuest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> text = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        String input;
        while (!"Stop".equals(input = sc.nextLine())) {
            String[] data = input.split("\\s+");
            switch (data[0]) {
                case "Delete":
                    //removes the word after the given index if it is valid.
                    int i = Integer.parseInt(data[1]);
                    if (i + 1 >= 0 && i + 1 < text.size()) {
                        text.remove(i + 1);
                    }
                    break;
                case "Swap":
                    //find the given words in the collections if they exist and swap their places.
                    int word1 = text.indexOf(data[1]);
                    int word2 = text.indexOf(data[2]);
                    if (word1 != -1 && word2 != -1) {
                        Collections.swap(text, word1, word2);
                    }
                    break;
                case "Put":
                    //add a word at the previous place {index - 1} before the given one, if it exists.
                    int index = Integer.parseInt(data[2]);
                    if (index - 1 >= 0 && index - 1 <= text.size()) {
                        text.add(index - 1, data[1]);
                    }
                    break;
                case "Sort":
                    //you must sort the words in descending order
                    text.sort(Comparator.reverseOrder());
                    break;
                case "Replace":
                    //word2 in the collection (if it exists) and replace it with the word1
                    int w2 = text.indexOf(data[2]);
                    if (w2 != -1) {
                        text.set(w2, data[1]);
                    }
                    break;
            }
        }
        text.stream().forEach(e -> System.out.print(e + " "));
    }
}
