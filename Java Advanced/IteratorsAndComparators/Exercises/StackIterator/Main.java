package IteratorsAndComparators.Exercises.StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> nums = new ArrayDeque<>();

        String input;
        while (!"END".equals(input = sc.readLine())){
            if (input.contains("Push")){
                Arrays.stream(input.split("([\\s,]+)"))
                        .skip(1)
                        .mapToInt(Integer::parseInt)
                        .forEach(nums::push);
            }else{
                try {
                nums.pop();
                }catch (Exception e){
                    System.out.println("No elements");
                }
            }
        }
        nums.forEach(System.out::println);
        nums.forEach(System.out::println);
    }
}
