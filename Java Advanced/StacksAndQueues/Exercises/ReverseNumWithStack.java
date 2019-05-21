package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<String> nums = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(" "))
                .forEach(nums::push);

        System.out.println(String.join(" ", nums));
    }
}
