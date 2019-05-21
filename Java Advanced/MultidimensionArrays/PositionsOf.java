package MultidimensionArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String[] dimensions = sc.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] data = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = data;
        }

        int needle = Integer.parseInt(sc.nextLine());
        boolean needleFound = true;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == needle){
                    System.out.println(row + " " + col);
                    needleFound = false;
                }
            }
        }
        if (needleFound){
            System.out.println("not found");
        }
    }
}
