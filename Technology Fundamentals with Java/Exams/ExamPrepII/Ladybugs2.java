package Exams.ExamPrepII;

import java.util.*;
import java.util.stream.Collectors;

public class Ladybugs2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] field = new int[n];
        int[] fill = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(i -> i >= 0 && i < field.length)
                .toArray();

        for (int i = 0; i < fill.length; i++) {
            field[fill[i]] = 1; // set indexes
        }

        String input;
        while (!"end".equals(input = sc.nextLine())) {
            String[] data = input.split("\\s+");
            String direction = data[1];
            int ladybugIndex = Integer.parseInt(data[0]);
            int flyLength = Integer.parseInt(data[2]);

            if (ladybugIndex >= 0 && ladybugIndex < field.length && field[ladybugIndex] == 1) {
                field[ladybugIndex] = 0;
                while (true) {
                    switch (direction) {
                        case "left": ladybugIndex -= flyLength; break;
                        case "right": ladybugIndex += flyLength; break;
                    }
                    if (ladybugIndex < 0 || ladybugIndex >= field.length) {
                        break;
                    }
                    if (field[ladybugIndex] == 1) {
                        continue;
                    }
                    if (field[ladybugIndex] == 0) {
                        field[ladybugIndex] = 1;
                        break;
                    }
                }

            }
        }
        System.out.println(Arrays.stream(field)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }
}
