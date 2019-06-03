package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Function;

public class SumNums2 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String[] nums = sc.nextLine().split(", ");

        if (nums.length < 2){
            System.out.println("Count = " + nums.length);
            System.out.println("Sum = " + nums[0]);
        }else{
            Function<String,Integer> parser = Integer::parseInt;
            int sum = 0;
            for (String x : nums) {
                sum += parser.apply(x);
            }
            System.out.println("Count = " + nums.length);
            System.out.println("Sum = " + sum);
        }
    }
}
