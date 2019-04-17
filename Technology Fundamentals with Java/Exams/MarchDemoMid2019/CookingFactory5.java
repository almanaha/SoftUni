package Exams.MarchDemoMid2019;

import java.util.*;
import java.util.stream.Collectors;

public class CookingFactory5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> batch1 = Arrays.stream(sc.nextLine().split("#"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input;
        while (!(input = sc.nextLine()).equals("Bake It!")) {
            List<Integer> batch2 = Arrays.stream(input.split("#"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int sum1 = batch1.stream().reduce((x, y) -> x += y).get();
            int sum2 = batch2.stream().reduce((x, y) -> x += y).get();
            if (sum1 < sum2) {
                batch1 = batch2;
            }
            if (sum1 == sum2 && batch1.size() > batch2.size()) {
                batch1 = batch2;
            }
        }
        System.out.println("Best Batch quality: " + batch1.stream().reduce((x, y) -> x += y).get());
        System.out.println(batch1.toString().replaceAll("\\[|\\]|,", ""));

    }
}