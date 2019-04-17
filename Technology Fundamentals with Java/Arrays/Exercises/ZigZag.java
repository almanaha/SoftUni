package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        int[] first = new int[count];
        int[] second = new int[count];

        for (int i = 0; i < count; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (i % 2 == 0){
                first[i] = arr[0];
                second[i] = arr[1];
            }else{
                first[i] = arr[1];
                second[i] = arr[0];
            }
        }

        for (int i : first) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : second) {
            System.out.print(i + " ");
        }
    }
}
