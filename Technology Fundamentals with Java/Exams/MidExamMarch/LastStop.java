package Exams.MidExamMarch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input;
        while (!"END".equals(input = sc.nextLine())) {
            String[] data = input.split("\\s+");
            switch (data[0]) {
                case "Change":
                    int index = numbers.indexOf(Integer.parseInt(data[1]));
                    if (index != -1) {
                        numbers.set(index, Integer.parseInt(data[2]));
                    }
                    break;
                case "Switch":
                    int index1 = numbers.indexOf(Integer.parseInt(data[1]));
                    int index2 = numbers.indexOf(Integer.parseInt(data[2]));
                    if (index1 != -1 && index2 != -1) {
                        Collections.swap(numbers, index1, index2);
                    }

                    break;
                case "Hide":
                    int in = numbers.indexOf(Integer.parseInt(data[1]));
                    if (in != -1) {
                        numbers.remove(in);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(numbers);
                    break;
                case "Insert":
                    int i = Integer.parseInt(data[1]);
                    if (i >= 0 && i < numbers.size()) {
                        numbers.add(i + 1, Integer.parseInt(data[2]));
                    }
                    break;
            }
        }
        numbers.stream().forEach(e -> System.out.print(e + " "));

    }
}
