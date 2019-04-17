package Arrays.MoreExercises;

import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // java program for Pascal's BasicSyntax.Exercises.Triangle
        // A O(n^2) time and O(n^2) extra
        // space method for Pascal's BasicSyntax.Exercises.Triangle

        int n = Integer.parseInt(sc.nextLine());

        // array to store generated pascal triangle values
        int[][] matrix = new int[n][n];

        for (int line  = 0; line  < n; line ++) {
            for (int index = 0; index <= line ; index++) {
                if (line  == index || index == 0) {
                    // First and last values in every row are 1
                    matrix[line ][index] = 1;
                    System.out.print(1 + " ");
                } else {
                    // Other values are sum of values just above and left of above
                    matrix[line][index] = matrix[line  - 1][index - 1] + matrix[line  - 1][index];
                    System.out.print(matrix[line ][index] + " ");
                }
            }
            System.out.println();
        }
    }
}
