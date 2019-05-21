package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, LinkedHashMap<String,Double>> shops = new TreeMap<>();
        String[] input = sc.nextLine().split(", ");

        while (!input[0].equals("Revision")){
            String store = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            LinkedHashMap<String, Double> products = new LinkedHashMap<>();
            if (shops.containsKey(store)){
                products = shops.get(store);
            }
            products.put(product,price);
            shops.put(store,products);

            input = sc.nextLine().split(", ");
        }

        for (String shop : shops.keySet()) {
            System.out.printf("%s->%n",shop);
            LinkedHashMap<String, Double> products = shops.get(shop);
            for (String name : products.keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",name,products.get(name));
            }
        }

    }
}
