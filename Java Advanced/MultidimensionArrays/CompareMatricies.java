package MultidimensionArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatricies {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] matrix1 = readMatrix();
        int[][] matrix2 = readMatrix();

        areEqual(matrix1,matrix2);
    }

    public static int[][] readMatrix() {
        int[] dimension = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] numbers = sc.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(numbers[col]);
            }
        }
        return matrix;
    }

    private static void areEqual(int[][] matrix1, int[][] matrix2) {

        if (matrix1[0].length != matrix2[0].length ||
                matrix1.length != matrix2.length){
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix2[0].length; col++) {
                if (matrix1[row][col] != matrix2[row][col]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
