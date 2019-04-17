package Exams.MarchDemoMid2019;

import java.util.*;
import java.util.stream.Collectors;

public class CookingFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int tmpQuality = 0;
        int bestQuality = 0;
        double bestAverageQuality = 0;
        double tmpAverageQuality = 0;
        int minLength = 11;

        List<Integer> bestBatch = new ArrayList<>();

        while (!input.equals("Bake It!")) {
            List<Integer> batch = Arrays.stream(input.split("#"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int i = 0; i < batch.size(); i++) {
                tmpQuality += batch.get(i);
            }
            tmpAverageQuality = tmpQuality / batch.size();
            if (tmpQuality > bestQuality){
                bestQuality = tmpQuality;
                bestBatch = batch;
            } else if (tmpQuality == bestQuality){
                if (tmpAverageQuality > bestAverageQuality){
                    bestBatch = batch;
                } else if (tmpAverageQuality == bestAverageQuality){
                    if (batch.size() < minLength){
                        bestBatch = batch;
                    }
                }
            }
            if (tmpAverageQuality > bestAverageQuality){
                bestAverageQuality = tmpAverageQuality;
            }
            input = sc.nextLine();
            tmpQuality = 0;
            //tmpAverageQuality = 0;
        }
        System.out.println("Best Batch quality: " + bestQuality);
        for (int i = 0; i < bestBatch.size(); i++) {
            System.out.print(bestBatch.get(i) + " ");
        }
    }
}
