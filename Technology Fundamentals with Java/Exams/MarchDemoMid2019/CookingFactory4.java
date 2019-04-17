package Exams.MarchDemoMid2019;
import java.util.*;

public class CookingFactory4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] batch1 = Arrays.stream(sc.nextLine().split("#"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input;
        while (!(input = sc.nextLine()).equals("Bake It!")) {
            int[] batch2 = Arrays.stream(input.split("#"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int sum1 = Arrays.stream(batch1).sum();
            int sum2 = Arrays.stream(batch2).sum();

            if (sum1 < sum2) {
                batch1 = batch2;
            }
            if (sum1 == sum2 && batch1.length > batch2.length) {
                batch1 = batch2;
            }
        }

        System.out.println("Best Batch quality: " + Arrays.stream(batch1).sum());
        Arrays.stream(batch1).forEach(e -> System.out.print(e + " "));
    }
}
