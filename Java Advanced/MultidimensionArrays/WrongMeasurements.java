package MultidimensionArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int dimension = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[dimension][];

        for (int i = 0; i < dimension; i++) {
            int[] row = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
        
        String[] coordinates = sc.nextLine().split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        int wrongValue = matrix[x][y];
        int[][] result = new int[dimension][];

        for (int i = 0; i < dimension; i++) {
            result[i] = matrix[i].clone();
        }

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (result[i][j] == wrongValue){
                    result[i][j] = Sum(matrix, i,j, wrongValue);
                }
            }
        }

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int Sum(int[][] matrix, int row, int col , int wrong) {
        int sum = 0;

        if (row - 1 >= 0 && matrix[row - 1][col] != wrong){
            sum += matrix[row - 1][col];
        }else if (row + 1 < matrix.length && matrix[row + 1][col] != wrong){
            sum += matrix[row + 1][col];
        }else if (col - 1 >= 0 && matrix[row][col - 1] != wrong){
            sum += matrix[row][col - 1];
        }else if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrong){
            sum += matrix[row][col + 1];
        }
        return sum;
    }
}
