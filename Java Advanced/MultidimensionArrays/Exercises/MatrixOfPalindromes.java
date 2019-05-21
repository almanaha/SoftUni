package MultidimensionArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String element = ""
                        + (char)('a' + row)
                        + (char)('a' + row + col)
                        + (char)(row + 'a');
                matrix[row][col] = element;
            }

        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+ " ");
            }
            System.out.println();
        }

    }
}
