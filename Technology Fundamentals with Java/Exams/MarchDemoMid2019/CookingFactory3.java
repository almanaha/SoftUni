package Exams.MarchDemoMid2019;

import java.util.*;
import java.util.stream.Collectors;

public class CookingFactory3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read first batch of breads, outside the while loop
        List<Integer> best = Arrays.stream(sc.nextLine().split("#"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bestQuality = best.stream().reduce((x, y) -> x += y).get();
        int bestAvg = bestQuality / best.size();

        String input;
        while (!(input = sc.nextLine()).equals("Bake It!")) {
            List<Integer> current = Arrays.stream(input.split("#"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int currentQuality = current.stream().reduce((x, y) -> x += y).get();
            int currentAvg = currentQuality / current.size();

            if (bestQuality < currentQuality) {
                best = current;
                bestQuality=currentQuality;
                bestAvg=currentAvg;
            } else if (bestQuality == currentQuality) {
                if (bestAvg < currentAvg) {
                    best = current;
                    bestQuality=currentQuality;
                    bestAvg=currentAvg;
                } else if (bestAvg == currentAvg) {
                    if (best.size() > current.size()) {
                        best = current;
                        bestQuality=currentQuality;
                        bestAvg=currentAvg;

                    }
                }
            }
        }
        System.out.println("Best Batch quality: "+bestQuality);
        System.out.println(best.toString().replaceAll("\\[|\\]|,",""));
    }
}
