package EXAMS.October2015;

import java.io.*;
import java.util.*;

public class DragonTrap {
    private static char[][] rotatedMatrix;
    private static ArrayList<Character> symbolsToRotate = new ArrayList<>();
    private static ArrayList<Cell> cellsToRotate = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(sc.readLine());
        String[] originalMatrix = new String[n];
        rotatedMatrix = new char[n][];

        for (int i = 0; i < n; i++) {
            String input = sc.readLine();

            originalMatrix[i] = input;
            rotatedMatrix[i] = input.toCharArray();
        }

        String command;
        while (!"End".equalsIgnoreCase(command = sc.readLine())) {
            String[] data = command
                    .replaceAll("[\\s()]+", " ")
                    .trim()
                    .split(" ");

            int centerRow = Integer.parseInt(data[0]);
            int centerCol = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);
            int rotations = Integer.parseInt(data[3]);

            getSymbolsToRotate(centerRow, centerCol, radius);

            if (symbolsToRotate.size() > 0) {
                rotations %= symbolsToRotate.size();

                if (rotations != 0) {
                    int index = rotations < 0 ? -rotations : symbolsToRotate.size() - rotations;

                    for (Cell cell : cellsToRotate) {
                        rotatedMatrix[cell.getRow()][cell.getColumn()] = symbolsToRotate.get(index);
                        index = (index + 1) % symbolsToRotate.size();
                    }
                }
            }

            symbolsToRotate.clear();
            cellsToRotate.clear();
        }

        printOutput(originalMatrix, rotatedMatrix);
    }

    private static void getSymbolsToRotate(int centerRow, int centerCol, int radius) {
        int startRow = centerRow - radius;
        int startCol = centerCol - radius;
        int endCol = centerCol + radius;
        int endRow = centerRow + radius;
        int row;
        int col;

        for (col = startCol, row = startRow; col <= endCol; col++) {
            if (isInsideMatrix(row, col, rotatedMatrix)) {
                symbolsToRotate.add(rotatedMatrix[row][col]);
                cellsToRotate.add(new Cell(row, col));
            }
        }

        for (row = startRow + 1, col = endCol; row <= endRow; row++) {
            if (isInsideMatrix(row, col, rotatedMatrix)) {
                symbolsToRotate.add(rotatedMatrix[row][col]);
                cellsToRotate.add(new Cell(row, col));
            }
        }

        for (col = endCol - 1, row = endRow; col >= startCol; col--) {
            if (isInsideMatrix(row, col, rotatedMatrix)) {
                symbolsToRotate.add(rotatedMatrix[row][col]);
                cellsToRotate.add(new Cell(row, col));
            }
        }

        for (row = endRow - 1, col = startCol; row > startRow; row--) {
            if (isInsideMatrix(row, col, rotatedMatrix)) {
                symbolsToRotate.add(rotatedMatrix[row][col]);
                cellsToRotate.add(new Cell(row, col));
            }
        }
    }

    private static boolean isInsideMatrix(int currentRow, int currentCol, char[][] matrix) {

        return 0 <= currentRow
                && currentRow < matrix.length
                && 0 <= currentCol
                && currentCol < matrix[currentRow].length;
    }

    private static void printOutput(String[] originalMatrix, char[][] rotatedMatrix) {
        int changedSymbols = 0;

        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix[i].length; j++) {
                if (rotatedMatrix[i][j] != originalMatrix[i].charAt(j)) {
                    changedSymbols++;
                }

                System.out.print(rotatedMatrix[i][j]);
            }

            System.out.println();
        }

        System.out.printf("Symbols changed: %d", changedSymbols);
    }
}

class Cell {
    private int row;
    private int column;

    Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    int getColumn() {
        return this.column;
    }
}
