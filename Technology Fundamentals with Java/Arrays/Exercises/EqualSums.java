package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isTrue = false;

        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0, rightSum = 0;

            for (int j = i - 1; j >= 0; j--) {
                leftSum += arr[j];
            }
            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }

            if (leftSum == rightSum){
                System.out.println(i);
                isTrue = true;
                break;
            }
        }
        if (!isTrue){
            System.out.println("no");
        }
    }
}
