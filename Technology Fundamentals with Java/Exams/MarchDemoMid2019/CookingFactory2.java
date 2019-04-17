package Exams.MarchDemoMid2019;

import java.util.*;
import java.util.stream.Collectors;

public class CookingFactory2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (true) {
            String inputCycle = scanner.nextLine();
            if (inputCycle.toLowerCase().equals("bake it!")) {
                break;
            } else {
                input = input.concat("|" + inputCycle);
            }
        }
        String[] batches = input.split("\\|");

        int bestQuality = Integer.MIN_VALUE;
        double bestAverage = Integer.MIN_VALUE;
        int bestSize = Integer.MAX_VALUE;
        ArrayList<Integer> bestList = new ArrayList<>();

        for (int i = 0; i < batches.length; i++) {

            ArrayList<Integer> nums = Arrays.stream(batches[i].split("#"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));

            int quality = calculateQuality(nums);
            double average = calculateAverage(nums, quality);
            int size = nums.size();


            if (quality > bestQuality) {
                bestQuality = quality;
                bestAverage = average;
                bestSize = size;
                bestList = nums;
            } else if (bestQuality == quality) {
                if (average > bestAverage) {
                    bestQuality = quality;
                    bestAverage = average;
                    bestSize = size;
                    bestList = nums;
                } else if (average == bestAverage) {
                    if (size < bestSize) {
                        bestQuality = quality;
                        bestAverage = average;
                        bestSize = size;
                        bestList = nums;
                    }
                }
            }
        }
        System.out.printf("Best Batch quality: %d%n", bestQuality);
        for (int n : bestList) {
            System.out.print(n + " ");
        }
    }


    public static int calculateQuality(ArrayList<Integer> list) {
        int quality = 0;
        for (int n : list) {
            quality += n;
        }
        return quality;
    }

    public static double calculateAverage(ArrayList<Integer> list, int quality) {
        double average = 0;
        double listSize = list.size();
        average = quality / listSize;
        return average;
    }
}