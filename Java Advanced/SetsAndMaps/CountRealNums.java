package SetsAndMaps;

import java.util.*;

public class CountRealNums {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        double[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numbers.putIfAbsent(nums[i], 0);
            numbers.put(nums[i], numbers.get(nums[i]) + 1);
        }
        for (Map.Entry<Double, Integer> x : numbers.entrySet()) {
            System.out.printf("%.1f -> %d%n", x.getKey(), x.getValue());
        }

    }
}
