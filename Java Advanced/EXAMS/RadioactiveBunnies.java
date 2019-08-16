package EXAMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RadioactiveBunnies {
    private static char[][] matrix;
    private static int initialRow = -1;
    private static int initialCol = -1;
    private static int playerRow = -1;
    private static int playerCol = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int[] dimm = Arrays.stream(sc.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        matrix = new char[dimm[0]][dimm[1]];
        for (int i = 0; i < dimm[0]; i++) {
            String line = sc.readLine();
            int n = line.indexOf('P');
            if (n != -1) {
                playerRow = i;
                playerCol = n;
            }
            matrix[i] = line.toCharArray();
        }


        String road = sc.readLine();
        for (char move : road.toCharArray()) {
            movePlayer(move);
            multiplyBunnies();

            if (playerIsInMatrix()) {
                if (matrix[playerRow][playerCol] == 'B') {
                    printMatrix();
                    System.out.println("dead: " + playerRow + " " + playerCol);
                    return;
                }
                continue;
            }
            printMatrix();
            System.out.println("won: " + initialRow + " " + initialCol);
            return;
        }
    }

    private static boolean playerIsInMatrix() {
        return playerRow >= 0 && playerRow < matrix.length
                && playerCol >= 0 && playerCol < matrix[playerRow].length;
    }

    private static void multiplyBunnies() {

        // mutants == '+'
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    if (row > 0) {
                        mutant(row - 1, col);
                    }
                    if (row < matrix.length - 1) {
                        mutant(row + 1, col);
                    }
                    if (col > 0) {
                        mutant(row, col - 1);
                    }
                    if (col < matrix[row].length - 1) {
                        mutant(row, col + 1);
                    }
                }
            }
        }
        //replace '+' ---> 'B'
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '+') {
                    matrix[i][j] = 'B';
                }
            }
        }
    }

    private static void mutant(int r, int c) {
        if (matrix[r][c] != 'B')
            matrix[r][c] = '+';
    }

    private static void movePlayer(char move) {
        initialRow = playerRow;
        initialCol = playerCol;
        matrix[initialRow][initialCol] = '.';

        switch (move) {
            case 'U':
                playerRow--;
                break;
            case 'D':
                playerRow++;
                break;
            case 'L':
                playerCol--;
                break;
            case 'R':
                playerCol++;
        }

        if (playerIsInMatrix() && matrix[playerRow][playerCol] != 'B'){
            matrix[playerRow][playerCol] = 'P';
        }
    }

    private static void printMatrix() {
        for (char[] chars : matrix) {
            for (char bunny : chars) {
                System.out.print(bunny);
            }
            System.out.println();
        }
    }
}
