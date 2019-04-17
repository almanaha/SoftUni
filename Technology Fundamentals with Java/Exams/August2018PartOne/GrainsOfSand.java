package Exams.August2018PartOne;

import java.util.*;
import java.util.stream.Collectors;

public class GrainsOfSand {
    public static List<Integer> sand;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sand = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String cmd = sc.nextLine();
        while (!cmd.equals("Mort")) {
            String[] data = cmd.split("\\s+");
            int value = Integer.parseInt(data[1]);
            switch (data[0]) {
                case "Add":
                    sand.add(value);
                    break;
                case "Remove":
                    remove(value);
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(data[2]);
                    replace(value, replacement);
                    break;
                case "Increase":
                    increase(value);
                    break;
                case "Collapse":
                    collapse(value);
                    break;
            }
            cmd = sc.nextLine();
        }

        for (Integer s : sand) {
            System.out.print(s + " ");
        }
    }
    private static void collapse(int value) {
        List<Integer> delete = new ArrayList<>();
        for (int i = 0; i < sand.size(); i++) {
            if (sand.get(i) < value) {
                delete.add(sand.get(i));
            }
        }
        sand.removeAll(delete);
    }
    private static void increase(int value) {
        boolean flag = false;
        for (Integer x : sand)
            if (x >= value) {
                flag = true;
                value = x;
                break;
            }

        if (!flag) {
            value = sand.get(sand.size() - 1);
        }

        for (int i = 0; i < sand.size(); i++) {
            sand.set(i, sand.get(i) + value);
        }
    }
    private static void replace(int value, int replacement) {
        int i = sand.indexOf(value);
        if (i != -1) {
            sand.set(i, replacement);
        }

    }
    private static void remove(int value) {
        int index = sand.indexOf(value);
        if (index != -1) {
            sand.remove(index);
        } else {
            if (value >= 0 && value < sand.size()) {
                sand.remove(value);
            }
        }
    }
}
