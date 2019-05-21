package MultidimensionArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingSystem2 {
    public static boolean[][] matrix;
    public static int rows;
    public static int cols;
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] data = sc.readLine().split("\\s+");
        rows = Integer.parseInt(data[0]);
        cols = Integer.parseInt(data[1]);
        matrix = new boolean[rows][cols];

        String input;
        while (!"stop".equals(input = sc.readLine())) {
            int stepsCounter = 1;
            data = input.split(" ");
            int startRow = Integer.parseInt(data[0]);
            int parkRow = Integer.parseInt(data[1]);
            if (isRowFull(matrix, parkRow)) {
                System.out.printf("Row %d full\n", parkRow);
            } else {
                int parkCol = Integer.parseInt(data[2]);
                stepsCounter += Math.abs(parkRow - startRow);
                if (!matrix[parkRow][parkCol]) {
                    stepsCounter += parkCol;
                    matrix[parkRow][parkCol] = true;
                    System.out.println(stepsCounter);
                } else {
                    int distance = Math.max(parkCol - 1, cols - 1 - parkCol);
                    for (int i = 1; i <= distance; i++) {
                        int leftIndex = Math.max(1, parkCol - i);
                        int rightIndex = Math.min(cols - 1, parkCol + i);
                        if (!matrix[parkRow][leftIndex]) {
                            matrix[parkRow][leftIndex] = true;
                            stepsCounter +=leftIndex;
                            break;
                        } else if (!matrix[parkRow][rightIndex]) {
                            matrix[parkRow][rightIndex] = true;
                            stepsCounter += rightIndex;
                            break;
                        }
                    }
                    System.out.println(stepsCounter);
                }

            }
        }
    }

    static boolean isRowFull(boolean[][] matrix, int row) {
        for (int i = 1; i < matrix[row].length; i++) {
            if (!matrix[row][i]) {
                return false;
            }
        }

        return true;
    }
}
