package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int counter = 1;
        int max = 1;
        int best = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]){
                counter++;
            }else{
                counter = 1;
            }

            if (max < counter){
                max = counter;
                best = i + 1;
            }
        }
        int start = (best - max) + 1;
        int end = start + max;

        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
