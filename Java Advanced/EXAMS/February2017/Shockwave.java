package EXAMS.February2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shockwave {
    private static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = sc.readLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        matrix = new int[rows][cols];

        String input;
        while (!"Here We Go".equalsIgnoreCase(input = sc.readLine())){
            int[] data = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int x1 = data[0];
            int y1 = data[1];
            int x2 = data[2];
            int y2 = data[3];

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    try {
                        matrix[i][j] += 1;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }

        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
