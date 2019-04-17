package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] arr2 = new int[arr.length - 1];

        if (arr.length == 1){
            System.out.println(arr[0]);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length - i; j++) {
                arr2[j] = arr[j] + arr[j + 1];
            }
            arr = arr2;
        }
        System.out.println(arr2[0]);
    }
}
