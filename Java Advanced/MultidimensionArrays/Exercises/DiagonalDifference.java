package MultidimensionArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DiagonalDifference {
    public static int[][] matrix;
    public static int sum;
    public static int row;
    public static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int dimension = Integer.parseInt(sc.readLine());
        matrix = new int[dimension][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(sc.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(Math.abs(firstDiagonal() - secondDiagonal()));
    }

    private static int firstDiagonal() {
        sum = 0;
        row = 0;
        col = 0;

        while (row < matrix.length) {
            sum += matrix[row++][col++];
        }
        return sum;
    }

    private static int secondDiagonal() {
        sum = 0;
        row = matrix.length - 1;
        col = 0;

        while (row >= 0) {
            sum += matrix[row--][col++];
        }
        return sum;
    }
}
