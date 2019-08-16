package EXAMS.April2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Crossfire {
    public static List<List<Integer>> matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(sc.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        fillMatrix(dimensions[0], dimensions[1]);

        String input;
        while (!"Nuke it from orbit".equalsIgnoreCase(input = sc.readLine())) {
            int[] data = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int shotRow = data[0];
            int shotCol = data[1];
            int radius = data[2];

            for (int currentRow = shotRow - radius; currentRow <= shotRow + radius; currentRow++) {
                if (isInMatrix(currentRow, shotCol)) {
                    matrix.get(currentRow).set(shotCol, -1);
                }
            }

            for (int currentCol = shotCol - radius; currentCol <= shotCol + radius; currentCol++) {
                if (isInMatrix(shotRow, currentCol)) {
                    matrix.get(shotRow).set(currentCol, -1);
                }
            }

            for (int row = 0; row < matrix.size(); row++) {
                matrix.get(row).removeAll(Collections.singletonList(-1));
            }
            matrix.removeAll(Collections.singletonList(new ArrayList<Integer>()));
        }

        for (List<Integer> integers : matrix) {
            StringBuilder currentLine = new StringBuilder();
            for (Integer integer : integers) {
                currentLine.append(integer).append(" ");
            }
            System.out.println(currentLine.toString().trim());
        }
    }

    private static void fillMatrix(int rows, int cols) {
        matrix = new ArrayList<>();
        int count = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count);
                count++;
            }
        }
    }

    private static boolean isInMatrix(int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < matrix.size() && currentCol >= 0 && currentCol < matrix.get(currentRow).size();
    }
}
