package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int sum = 0;

        for (int n : numbers) {
            if (n % 2 == 0){
                sum += n;
            }
        }
        System.out.println(sum);
    }
}
