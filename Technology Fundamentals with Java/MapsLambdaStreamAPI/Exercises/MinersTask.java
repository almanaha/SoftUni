package MapsLambdaStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinersTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String product = sc.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!product.equals("stop")) {
            int quantity = Integer.parseInt(sc.nextLine());
            if (!resources.containsKey(product)) {
                resources.put(product, quantity);
            } else {
                resources.put(product, resources.get(product) + quantity);
            }
            product = sc.nextLine();
        }
        resources.entrySet().forEach(x -> System.out.println(x.getKey() + " -> " + x.getValue()));
    }
}
