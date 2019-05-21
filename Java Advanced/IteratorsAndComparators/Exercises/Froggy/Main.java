package IteratorsAndComparators.Exercises.Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int[] stones = Arrays.stream(sc.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(stones);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : lake) {
            sb.append(integer).append(", ");
        }
        System.out.println(sb.substring(0,sb.length() - 2));
    }
}
