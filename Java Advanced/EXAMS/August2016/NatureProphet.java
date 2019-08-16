package EXAMS.August2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NatureProphet {
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        matrix = new int[dimensions[0]][dimensions[1]];

        String input;
        while (!"Bloom Bloom Plow".equalsIgnoreCase(input = sc.readLine())) {
            int[] data = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int row = data[0];
            int col = data[1];
            int initialNumber = matrix[row][col] + 1;

            for (int j = 0; j < matrix.length; j++) {
                matrix[row][j] += 1;
                matrix[j][col] += 1;
            }
            matrix[row][col] = initialNumber;
        }
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
