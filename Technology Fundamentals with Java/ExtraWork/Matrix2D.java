package ExtraWork;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix2D {
    public static void main(String[] args) {
        //Calculate the hourglass sum for every hourglass in ,
        // then print the maximum hourglass sum.
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //top row
                sum += arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                // middle
                sum += arr[i + 1][j + 1];
                // bottom row
                sum += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                if (sum > max || i == 0 && j == 0) {
                    max = sum;
                }
                // reset sum
                sum = 0;
            }
        }
        System.out.println(max);
    }
}
