package StringProcessingAndRegex.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\%(?<customer>[A-Z][a-z]+)\\%[^|$%.]*\\<(?<product>\\w+)\\>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+([.]\\d+)?)\\$");
        List<Order> orders = new ArrayList<>();
        String input;
        while (!"end of shift".equals(input = sc.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                String name = matcher.group("customer");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                Order order = new Order(name, product, quantity, price);
                orders.add(order);
            }
        }
        double totalIncome = 0;
        for (Order order : orders) {
            System.out.println(order.toString());
            totalIncome += order.quantity * order.price;
        }
        System.out.printf("Total income: %.2f\n",totalIncome);
    }

    static class Order {
        private String customerName;
        private String product;
        private int quantity;
        private double price;

        @Override
        public String toString() {
            return String.format("%s: %s - %.2f",
                    this.customerName,
                    this.product,
                    this.quantity * this.price);
        }

        public Order(String customerName, String product, int quantity, double price) {
            this.customerName = customerName;
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }
}
