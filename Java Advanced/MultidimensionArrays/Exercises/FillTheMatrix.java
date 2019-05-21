package MultidimensionArrays.Exercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] input = sc.nextLine().split(", ");

        int dimension = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[dimension][dimension];

        if (pattern.equals("A")) {
            patternA(matrix);
        } else {
            patternB(matrix);
        }
        // Print:
        for (int col = 0; col < dimension; col++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[col][j] + " ");
            }
            System.out.println();
        }
    }

    private static void patternB(int[][] matrix) {
        int count = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = count++;
                }
            }else{
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = count++;
                }
            }
        }
    }

    private static void patternA(int[][] matrix) {
        int count = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = count++;
            }
        }
    }
}
