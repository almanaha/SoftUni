package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SubstractionEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int odd = 0;
        int even = 0;
        for (int num : numbers) {
            if (num % 2 == 0){
                even += num;
            }else{
                odd += num;
            }
        }
        int result = even - odd;
        System.out.println(result);
    }
}
