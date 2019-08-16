package EXAMS.October2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DragonTrap2 {
    private static char[][] matrix;
    private static char[][] initialMatrix;
    private static List<int[]> positions;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(sc.readLine());
        matrix = new char[n][];
        initialMatrix = new char[n][];

        for (int i = 0; i < n; i++) {
            String line = sc.readLine();
            matrix[i] = line.toCharArray();
            initialMatrix[i] = line.toCharArray();
        }

        String input;
        while (!"End".equalsIgnoreCase(input = sc.readLine())) {
            String[] data = input
                    .replaceAll("[)(]+", "")
                    .split("\\s+");
            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);
            int rotation = Integer.parseInt(data[3]);

            int top = row - radius;
            int bottom = row + radius;
            int left = col - radius;
            int right = col + radius;

            String borders = getBorders(top, bottom, left, right);
            if (rotation != 0 && borders.length() > 0) {
                borders = rotateBorders(borders, rotation);
                for (int i = 0; i < borders.length(); i++) {
                    int currentRow = positions.get(i)[0];
                    int currentCol = positions.get(i)[1];
                    char currentChar = borders.charAt(i);

                    matrix[currentRow][currentCol] = currentChar;
                }
            }
        }
        print();
    }

    private static void print() {
        int symbols = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
                if (matrix[row][col] != initialMatrix[row][col]){
                    symbols++;
                }
            }
            System.out.println();
        }
        System.out.println("Symbols changed: " + symbols);
    }

    private static String rotateBorders(String borders, int rotations) {
        String leftPart;
        String rightPart;
        if (rotations < 0) {
            rotations = Math.abs(rotations) % borders.length();
            leftPart = borders.substring(0, rotations);
            rightPart = borders.substring(rotations);
        } else {
            rotations %= borders.length();
            leftPart = borders.substring(0, borders.length() - rotations);
            rightPart = borders.substring(borders.length() - rotations);
        }
        return rightPart + leftPart;
    }

    private static String getBorders(int top, int bottom, int left, int right) {
        StringBuilder borders = new StringBuilder();
        positions = new ArrayList<>();

        if (top >= 0 && top < matrix.length) {
            int minCol = Math.max(0, left);
            int maxCol = Math.min(matrix[0].length - 1, right);
            for (int i = minCol; i <= maxCol; i++) {
                borders.append(matrix[top][i]);
                positions.add(new int[]{top, i});
            }
            top++;
        }

        if (right >= 0 && right < matrix[0].length) {
            int minRow = Math.max(0, top);
            int maxRow = Math.min(matrix.length - 1, bottom);
            for (int i = minRow; i <= maxRow; i++) {
                borders.append(matrix[i][right]);
                positions.add(new int[]{i, right});
            }
            right--;
        }
        if (bottom >= 0 && bottom < matrix.length) {
            int minCol = Math.max(0, left);
            int maxCol = Math.min(matrix[0].length - 1, right);
            for (int i = maxCol; i >= minCol; i--) {
                borders.append(matrix[bottom][i]);
                positions.add(new int[]{bottom, i});
            }
            bottom--;
        }
        if (left >= 0 && left < matrix[0].length) {
            int minCol = Math.max(0, top);
            int maxCol = Math.min(matrix[0].length - 1, bottom);
            for (int i = maxCol; i >= minCol; i--) {
                borders.append(matrix[i][left]);
                positions.add(new int[]{i, left});
            }
        }
        return borders.toString();
    }
}
