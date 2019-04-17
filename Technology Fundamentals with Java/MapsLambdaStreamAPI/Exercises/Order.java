package MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class Order {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Double> products = new LinkedHashMap<>(); // with price
        Map<String, Integer> quantities = new LinkedHashMap<>();

        String input;
        while (!"buy".equals(input = sc.nextLine())) {
            String[] data = input.split("\\s+");
            String product = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);

            products.put(product, price);

            if (!quantities.containsKey(product)) {
                quantities.put(product, quantity);
            } else {
                quantities.put(product, quantities.get(product) + quantity);
            }
        }
        for (Map.Entry<String, Double> p : products.entrySet()) {
            System.out.printf("%s -> %.2f%n", p.getKey(),
                    p.getValue() * quantities.get(p.getKey()));
        }
    }
}
