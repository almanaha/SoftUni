package MultidimensionArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElement {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String[] dimensions = sc.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            sum += Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
