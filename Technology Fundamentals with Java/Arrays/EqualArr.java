package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int[] arr2 = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int sum = 0;
        int max = Math.max(arr1.length, arr2.length);
        for (int i = 0; i < max; i++) {
            sum += arr1[i];
            if (arr1[i] != arr2[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", arr1[i - 1]);
                return;
            }
        }
        System.out.printf("Arrays are identical. Sum: %d", sum);

    }
}
