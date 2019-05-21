package MultidimensionArrays;

import java.util.Scanner;

public class FindTheRealQueen {
    public static final int size = 8;
    public static final char queen = 'q';
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String[] data = sc.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = data[j].charAt(0);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == queen) {
                    if (isQueen(matrix, i, j)){
                        System.out.println(i + " " + j);
                        return;
                    }

                }
            }
        }

    }

    private static boolean isQueen(char[][] matrix, int row, int col) {
        return isQueenRowValid(matrix, row) &&
                isQueenColValid(matrix, col) &&
                isQueenFirstValid(matrix, row, col) &&
                isQueenSecondValid(matrix, row, col);
    }

    private static boolean isQueenColValid(char[][] matrix, int col) {
        int queensCount = 0;
        for (int i = 0; i < size; i++) {
            if (matrix[i][col] == queen) {
                queensCount++;
            }
        }
        return queensCount == 1; // boolean true/false
    }

    private static boolean isQueenRowValid(char[][] matrix, int row) {
        int queensCount = 0;
        for (int i = 0; i < size; i++) {
            if (matrix[row][i] == queen) {
                queensCount++;
            }
        }
        return queensCount == 1; // boolean true/false
    }

    private static boolean isQueenFirstValid(char[][] matrix, int row, int col) {
        int queensCount = 0;
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (matrix[row - i][col - i] == queen) {
                queensCount++;
            }
        }

        for (int i = 1; row + i <= size && col + i < size; i++) {
            if (matrix[row + i][col + i] == queen) {
                queensCount++;
            }
        }

        return queensCount == 0; // boolean true/false
    }

    private static boolean isQueenSecondValid(char[][] matrix, int row, int col) {
        int queensCount = 0;
        for (int i = 1; row - i >= 0 && col + i < size; i++) {
            if (matrix[row - i][col + i] == queen) {
                queensCount++;
            }
        }

        for (int i = 1; row + i < size && col - i >= 0; i++) {
            if (matrix[row + i][col - i] == queen) {
                queensCount++;
            }
        }

        return queensCount == 0; // boolean true/false
    }

}
