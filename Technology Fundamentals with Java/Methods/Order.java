package Methods;

import java.util.Scanner;

public class Order {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String product = sc.nextLine();
        double count = Double.parseDouble(sc.nextLine());
        OrderPrice(product,count);
    }

    public static void OrderPrice(String product, double count) {
        if (product.equals("water")) System.out.printf("%.2f",count * 1.00);
        else if (product.equals("coffee")) System.out.printf("%.2f",count * 1.50);
        else if (product.equals("coke")) System.out.printf("%.2f",count * 1.40);
        else if (product.equals("snacks")) System.out.printf("%.2f",count * 2.00);
    }
}
