package MultidimensionArrays.Exercises;

import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;

public class MatrixShuffling {
    public static String[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        matrix = new String[dimensions[0]][dimensions[1]];

        for (int i = 0; i < dimensions[0]; i++) {
            matrix[i] = sc.readLine().split("\\s+");
        }

        String input;
        while (!"END".equals(input = sc.readLine())) {
            String[] data = input.split("\\s+");


            if (data[0].equals("swap") && data.length > 1 && data.length < 6) {
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                if (row1 >= 0 && row1 < dimensions[0] &&
                        row2 >= 0 && row2 < dimensions[0] &&
                        col1 >= 0 && col1 < dimensions[1] &&
                        col2 >= 0 && col2 < dimensions[1]){
                    String swap = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = swap;

                    for (int i = 0; i < dimensions[0]; i++) {
                        System.out.println(String.join(" ", matrix[i]));
                    }
                }else{
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
