package StacksAndQueues.Exercises;
import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> numbers = new ArrayDeque<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] nums = sc.nextLine().split(" ");
            if (nums[0].equals("1")){
                numbers.push(Integer.parseInt(nums[1]));
            }else if (nums[0].equals("2")){
                numbers.pop();
            }else{
                System.out.println(Collections.max(numbers));
            }
        }
    }
}
