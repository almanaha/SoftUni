package MapsLambdaStreamAPI;

import java.text.DecimalFormat;
import java.util.*;

public class CountRealNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> countByNumber = new TreeMap<>();

        for (double number : numbers) {
            if (!countByNumber.containsKey(number)){
                countByNumber.put(number, 0);
            }

            int lastValue = countByNumber.get(number);
            countByNumber.put(number, lastValue + 1);

        }
        DecimalFormat df = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> pair : countByNumber.entrySet()) {
            double number = pair.getKey();
            String formatedNum = df.format(number);
            int count = pair.getValue();
            System.out.printf("%s -> %d%n",formatedNum,count);

        }

    }
}
