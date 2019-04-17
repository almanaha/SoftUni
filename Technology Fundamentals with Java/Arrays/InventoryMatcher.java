package Arrays;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryMatcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] products = sc.nextLine().split(" ");
        String[] quantities = sc.nextLine().split(" ");

        String[] prices = sc.nextLine().split(" ");

        Map<String, String> quantitiesByProduct = new HashMap<>();
        Map<String, String> pricesByProduct = new HashMap<>();

        for (int i = 0; i < products.length; i++) {
            String product = products[i];
            quantitiesByProduct.put(product, quantities[i]);
            pricesByProduct.put(product, prices[i]);
        }

        String product = sc.nextLine();

        while (!product.equals("done")){
            System.out.printf("%s costs: %s; Available quantity: %s%n",
                    product,
                    pricesByProduct.get(product),
                    quantitiesByProduct.get(product)
                    );
            product = sc.nextLine();
        }

    }
}
