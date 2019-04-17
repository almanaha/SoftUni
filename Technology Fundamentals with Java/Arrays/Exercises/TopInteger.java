package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < arr.length; i++) {

            boolean isBigger = true;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] <= arr[j]){
                    isBigger = false;
                }
            }
            if (isBigger){
                System.out.print(arr[i] + " ");
            }
        }
    }
}
