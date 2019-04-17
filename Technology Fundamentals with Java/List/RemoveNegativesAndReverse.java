package List;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        nums.removeIf(e -> e < 0);
        Collections.reverse(nums);

        if (nums.isEmpty()){
            System.out.println("empty");
        }else{
            nums.forEach(e -> System.out.print(e + " "));
        }
    }
}
