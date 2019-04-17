package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrix = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = sc.nextLine();

        while (!command.equals("end")) {
            String[] arrCommands = command.split(" ");
            if (arrCommands[0].equals("exchange")) {
                int index = Integer.parseInt(arrCommands[1]);
                if (index >= 0 && index < matrix.length)
                    exchange(matrix, index);
                else
                    System.out.println("Invalid index");

            } else if (arrCommands[0].equals("max")) {
                int index = -1;
                if (arrCommands[1].equals("even")) {
                    index = findMaxEven(matrix);
                    if (index != -1)
                        System.out.println(index);
                    else
                        System.out.println("No matches");
                } else {
                    index = findMaxOdd(matrix);
                    if (index != -1)
                        System.out.println(index);
                    else
                        System.out.println("No matches");

                }
            } else if (arrCommands[0].equals("min")) {
                int index = -1;
                if (arrCommands[1].equals("even")) {
                    index = findMinEven(matrix);
                    if (index != -1)
                        System.out.println(index);
                    else
                        System.out.println("No matches");
                } else {
                    index = findMinOdd(matrix);
                    if (index != -1)
                        System.out.println(index);
                    else
                        System.out.println("No matches");

                }
            } else if (arrCommands[0].equals("first")) {
                int count = Integer.parseInt(arrCommands[1]);
                if (arrCommands[2].equals("even")) {
                    if (count < matrix.length)
                        printFirstEven(matrix, count);
                    else
                        System.out.println("Invalid count");

                } else {
                    if (count < matrix.length)
                        printFirstOdd(matrix, count);
                    else
                        System.out.println("Invalid count");

                }
            } else if (arrCommands[0].equals("last")) {

            }
            command = sc.nextLine();
        }
    }

    private static void printFirstOdd(int[] matrix, int count) {
        int[] copy = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] % 2 != 0 && count > 0){
                count--;
                copy[i] = matrix[i];
            }else{
                copy[i] = -1;
            }
        }
        printArray(copy);

    }

    private static void printFirstEven(int[] matrix, int count) {
        int[] copy = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] % 2 == 0){
                count--;
                copy[i] = matrix[i];
            }else{
                copy[i] = -1;
            }
        }
        printArray(copy);
    }

    private static int findMinOdd(int[] matrix) {
        int index = -1; // ако върне -1 значи не съм намерил елемента
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (min >= matrix[i] && matrix[i] % 2 != 0) {
                min = matrix[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMinEven(int[] matrix) {
        int index = -1; // ако върне -1 значи не съм намерил елемента
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (max >= matrix[i] && matrix[i] % 2 == 0) {
                max = matrix[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMaxOdd(int[] matrix) {
        int index = -1; // ако върне -1 значи не съм намерил елемента
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (min <= matrix[i] && matrix[i] % 2 != 0) {
                min = matrix[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMaxEven(int[] matrix) {
        int index = -1; // ако върне -1 значи не съм намерил елемента
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (max <= matrix[i] && matrix[i] % 2 == 0) {
                max = matrix[i];
                index = i;
            }
        }
        return index;
    }

    private static void printArray(int[] matrix) {
        System.out.print("[");
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != -1) {
                if (i != matrix.length - 1) {
                    System.out.print(matrix[i] + ", ");
                } else {
                    System.out.print(matrix[i]);
                }
            }
        }
        System.out.print("]");
    }

    private static void exchange(int[] matrix, int index) {
        int[] first = new int[index + 1];
        int[] second = new int[matrix.length - (index + 1)];

        for (int i = 0; i <= index; i++) {
            first[i] = matrix[i];
        }
        for (int i = index + 1; i < matrix.length; i++) {
            second[i - (index + 1)] = matrix[i];
        }
        for (int i = 0; i < second.length; i++) {
            matrix[i] = second[i];
        }
        for (int i = 0; i < first.length; i++) {
            matrix[i + second.length] = first[i];
        }
    }
}
