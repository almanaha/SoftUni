package Exams.MidExamMarch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelloFrance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> items = Arrays.stream(sc.nextLine().split("\\|"))
                .collect(Collectors.toList());
        double budget = Double.parseDouble(sc.nextLine());

        List<Double> prices = new ArrayList<>();
        double profit = 0;

        for (int i = 0; i < items.size(); i++) {
            String[] data = items.get(i).split("->");
            double price = Double.parseDouble(data[1]);
            switch (data[0]) {
                case "Clothes":
                    if (price <= 50.00 && budget >= price) {
                        budget -= price;
                        profit += (price * 0.4);
                        price = (price * 1.4);
                        prices.add(price);
                    }
                    break;
                case "Shoes":
                    if (price <= 35.00 && budget >= price) {
                        budget -= price;
                        profit += (price * 0.4);
                        price = (price * 1.4);
                        prices.add(price);
                    }
                    break;
                case "Accessories":
                    if (price <= 20.50 && budget >= price) {
                        budget -= price;
                        profit += (price * 0.4);
                        price = (price * 1.4);
                        prices.add(price);
                    }
                    break;
            }
        }
        for (Double m : prices) {
            budget += m;
        }
        for (int i = 0; i < prices.size(); i++) {
            if (i == prices.size() - 1) {
                System.out.printf("%.2f", prices.get(i));
            } else {
                System.out.printf("%.2f ", prices.get(i));
            }
        }
        System.out.println();
        System.out.printf("Profit: %.2f%n", profit);

        if (budget >= 150.0) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }
    }
}