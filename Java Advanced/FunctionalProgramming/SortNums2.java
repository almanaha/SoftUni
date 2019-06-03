package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortNums2 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        List<Integer> nums = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        nums.removeIf(n -> n % 2 != 0);

        if (!nums.isEmpty()){
            System.out.println(nums);
            nums.sort(Integer::compareTo);
            System.out.println(nums);
        }

    }
}
