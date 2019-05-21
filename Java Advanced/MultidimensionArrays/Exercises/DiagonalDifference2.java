package MultidimensionArrays.Exercises;
import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference2 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int dimension = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int row = 0,
                col = 0;
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int i = 0; i < dimension; i++) {
            if (row == col && row == i){
                primaryDiagonal += matrix[row][col];
            }else if (row == i && col == dimension - 1 - i){
                secondaryDiagonal += matrix[row][col];
            }
            row++;
            col++;
        }
        int sum = Math.abs(primaryDiagonal - secondaryDiagonal);
        System.out.println(sum);
    }
}
