package MultidimensionArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static Scanner sc = new Scanner(System.in);

    private static int sum = 0;
    private static int[][] tempMatrix = new int[3][3];

    public static void main(String[] args) {

        String[] input = sc.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = 0;
        int[][] best = new int[3][3];

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                matrixSum(matrix, row, col);

                if (sum > maxSum) {
                    maxSum = sum;
                    best = tempMatrix;
                }
            }
        }

        System.out.println("Sum = " + maxSum);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(best[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void matrixSum(int[][] matrix, int rows, int cols) {
        sum = 0;
        tempMatrix = new int[3][3];

        int matrixRow = 0;
        for (int row = rows - 1; row <= rows + 1; row++) {
            int matrixCol = 0;
            for (int col = cols - 1; col <= cols + 1; col++) {
                sum += matrix[row][col];
                tempMatrix[matrixRow][matrixCol++] = matrix[row][col];
            }
            matrixRow++;
        }
    }
}
