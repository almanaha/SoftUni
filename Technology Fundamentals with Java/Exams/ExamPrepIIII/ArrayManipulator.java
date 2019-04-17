package Exams.ExamPrepIIII;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayManipulator {
    public static List<Integer> matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        matrix = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input;
        while (!"end".equals(input = sc.nextLine())) {
            String[] data = input.split("\\s+");
            int index = 0;
            String type;
            switch (data[0]) {
                case "exchange":
                    index = Integer.parseInt(data[1]);
                    if (index >= 0 && index < matrix.size()) {
                        for (int i = 0; i < index; i++) {
                            matrix.add(0, matrix.get(matrix.size() - 1));
                            matrix.remove(matrix.size() - 1);
                        }
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    type = data[1];
                    getMax(type);
                    break;
                case "min":
                    type = data[1];
                    getMin(type);
                case "first":
                    int count = Integer.parseInt(data[1]);
                    type = data[2];
                    getFirst(count, type);
                case "last":
                    int n = Integer.parseInt(data[1]);
                    type = data[2];
                    getLast(n, type);
            }
        }
        System.out.println(matrix.toString());
    }

    private static void getLast(int count, String type) {
        List<Integer> arr = new ArrayList<>();
        for (int i = matrix.size() - 1; i >= 0; i--) {
            if (type.equals("even")) {
                if (matrix.get(i) % 2 == 0 && count > 0) {
                    count--;
                    arr.add(i);
                }
            } else {
                if (matrix.get(i) % 2 != 0 && count > 0) {
                    count--;
                    arr.add(i);
                }
            }
        }
        if (arr.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println(arr.toString());
        }
    }

    private static void getFirst(int count, String type) {
        List<Integer> arr = new ArrayList<>();
        for (Integer i : matrix) {
            if (type.equals("even")) {
                if (i % 2 == 0 && count > 0) {
                    count--;
                    arr.add(i);
                }
            } else {
                if (i % 2 != 0 && count > 0) {
                    count--;
                    arr.add(i);
                }
            }
        }
        if (arr.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println(arr.toString());
        }
    }

    private static void getMin(String type) {
        int even = 0;
        int odd = 0;
        for (Integer i : matrix) {
            if (i % 2 == 0 && even > i) {
                even = matrix.indexOf(i);
            } else if (i % 2 != 0 && odd > 0) {
                odd = matrix.indexOf(i);
            }
        }
        if (even == 0 || odd == 0){
            System.out.println("No matches");
        }else {
            if (type.equals("even")) {
                System.out.println(even);
            } else {
                System.out.println(odd);
            }
        }
    }

    private static void getMax(String type) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.get(i) % 2 == 0 && even < matrix.get(i)) {
                even = i;
            } else if (matrix.get(i) % 2 != 0 && odd < matrix.get(i)) {
                odd = i;
            }
        }
        if (even == 0 || odd == 0){
            System.out.println("No matches");
        }else {
            if (type.equals("even")) {
                System.out.println(even);
            } else {
                System.out.println(odd);
            }
        }
    }
}
