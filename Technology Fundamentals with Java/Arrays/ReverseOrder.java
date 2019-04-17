package Arrays;

import java.util.Scanner;

public class ReverseOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in.nextLine());
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            System.out.println(nums[j]);
        }
    }
}
