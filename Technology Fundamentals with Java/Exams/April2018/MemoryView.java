package Exams.April2018;

import java.util.*;

public class MemoryView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        String input = sc.nextLine();
        while (!input.equals("Visual Studio crash")) {
            line.append(input).append(" ");
            input = sc.nextLine();
        }
        String[] data = line.toString().split("\\s+");
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("32656") &&
                    data[i + 1].equals("19759") &&
                    data[i + 2].equals("32763") &&
                    data[i + 3].equals("0") &&
                    data[i + 5].equals("0")) {

                int length = Integer.parseInt(data[i + 4]);

                StringBuilder word = new StringBuilder();
                for (int j = i + 6; j <= i + 6 + length; j++) {
                    word.append((char) (Integer.parseInt(data[j])));
                }
                words.add(word.toString());
            }
        }
        words.forEach(System.out::println);
    }
}
