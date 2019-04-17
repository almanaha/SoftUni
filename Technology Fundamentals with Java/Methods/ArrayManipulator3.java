package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator3 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] matrix = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = "";

        while (!"end".equals(command = sc.nextLine())) {
            String[] data = command.split("\\s+");
            String cmd = data[0];

            switch (cmd) {
                case "exchange":
                    exchange(matrix, Integer.parseInt(data[1]));
                    break;
                case "max":
                    maxElementIndex(matrix, data[1]);
                    break;
                case "min":
                    minElementIndex(matrix, data[1]);
                    break;
                case "first":
                    firstElements(matrix, Integer.parseInt(data[1]), data[2]);
                    break;
                case "last":
                    lastElements(matrix, Integer.parseInt(data[1]), data[2]);
                    break;
            }
        }
        System.out.println(Arrays.toString(matrix));
    }

    private static void lastElements(int[] matrix, int count, String command) {
        if (validateCount(matrix, count)) return;
        int num = command.equals("even") ? 0 : 1;
        int index = 0;
        FillElements(matrix, count, num, index,"last");

    }

    private static void firstElements(int[] matrix, int count, String command) {
        if (validateCount(matrix, count)) return;
        int num = command.equals("even") ? 0 : 1;
        int index = 0;
        FillElements(matrix, count, num, index,"first");


    }

    private static boolean validateCount(int[] matrix, int count) {
        if (count < 0 || count > matrix.length) {
            System.out.println("Invalid count");
            return true;
        }
        return false;
    }

    private static void FillElements(int[] matrix, int count, int num, int index , String command) {
        int[] result = new int[0];

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] % 2 == num) {
                if (index == result.length) {
                    result = changeArraySize(result);
                }
                result[index++] = matrix[i];
            }
        }
        Arrays.stream(result).filter(e -> e != 0).toArray();

        if (index == 0) {
            System.out.println("[]");
        } else {
            int minCount = Math.min(count, result.length);
            String output = "[";
            if (command.equals("first")) {
                for (int i = 0; i < minCount; i++) {
                    if (i < minCount - 1) {
                        output += result[i] + ", ";
                    } else {
                        output += result[i] + "]";
                    }
                }
            }else{
                int countElements = 0;
                for (int i = 0; i < minCount; i++) {
                    if (i < minCount - 1) {
                        output += result[result.length - minCount + countElements++] + ", ";
                    } else {
                        output += result[result.length - minCount + countElements++] + "]";
                    }
                }
            }
            System.out.println(output);
        }
    }

    private static int[] changeArraySize(int[] result) {
        int[] newArray = new int[result.length + 1];
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            newArray[count++] = result[i];
        }

        return newArray;
    }

    private static void minElementIndex(int[] matrix, String command) {
        int num = command.equals("even") ? 0 : 1; // if even 0 , odd 1;
        int maxElement = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] % 2 == num) {
                if (matrix[i] <= maxElement) {
                    maxElement = matrix[i];
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    private static void maxElementIndex(int[] matrix, String command) {
        int num = command.equals("even") ? 0 : 1; // if even 0 , odd 1;
        int minElement = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] % 2 == num) {
                if (matrix[i] >= minElement) {
                    minElement = matrix[i];
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    private static void exchange(int[] matrix, int index) {
        int[] result = new int[matrix.length];
        int count = 0;

        if (index < 0 || index >= matrix.length) {
            System.out.println("Invalid index");
        } else {
            for (int i = index + 1; i < matrix.length; i++) {
                result[count++] = matrix[i];
            }
            for (int i = 0; i <= index; i++) {
                result[count++] = matrix[i];
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = result[i];
            }
        }
    }
}
