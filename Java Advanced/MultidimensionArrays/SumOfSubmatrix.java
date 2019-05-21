package MultidimensionArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfSubmatrix {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String[] dimensions = sc.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] data = Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = data;
        }

        int sum = Integer.MIN_VALUE,
                maxRow = 0, maxCol = 0;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {

                int currentSum = sumFromTopLeft(matrix,i,j);
                if (currentSum > sum){
                    sum = currentSum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.printf("%d %d%n%d %d%n%d",
                matrix[maxRow][maxCol],
                matrix[maxRow][maxCol + 1],
                matrix[maxRow + 1][maxCol],
                matrix[maxRow + 1][maxCol + 1],sum);

    }
    private static int sumFromTopLeft(int[][] matrix,int row, int col){
        return matrix[row][col] +
                matrix[row + 1][col] +
                matrix[row][col + 1] +
                matrix[row + 1][col + 1];
    }
}
