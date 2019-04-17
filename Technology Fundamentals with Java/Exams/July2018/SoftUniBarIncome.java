package Exams.July2018;

import java.util.*;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double income = 0;
        String input = sc.nextLine();

        while (!input.equals("end of shift")) {
            int percentageIndex = input.indexOf("%");
            int percentageEnd = input.indexOf("%", percentageIndex + 1);
            boolean isValidCustomer = false;
            boolean isValidProduct = false;
            boolean isInt = false;
            boolean isValidPrice = false;
            int productCount = 0;
            String customer = "",
                    product = "",
                    count = "",
                    price = "";

            if (percentageIndex != -1 && percentageEnd != -1) {
                customer = input.substring(percentageIndex + 1, percentageEnd);
                isValidCustomer = validateCustomer(customer);
            }

            int diamondIndex = input.indexOf("<");
            int diamondEnd = input.indexOf(">", diamondIndex + 1);
            if (diamondIndex != -1 && diamondEnd != -1) {
                product = input.substring(diamondIndex + 1, diamondEnd);
                isValidProduct = validateProduct(product);
            }

            int pipeIndex = input.indexOf("|");
            int pipeEnd = input.indexOf("|", pipeIndex + 1);
            if (pipeIndex != -1 && pipeEnd != -1) {
                count = input.substring(pipeIndex + 1, pipeEnd);
                try {
                    productCount = Integer.parseInt(count);
                    isInt = true;
                } catch (Exception e) {
                    isInt = false;
                }
            }

            int dollarIndex = input.indexOf("$");
            if (dollarIndex != -1) {
                isValidPrice = true;
                for (int i = dollarIndex - 1; i > 0; i--) {
                    if (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.') {
                        price = input.charAt(i) + price;
                    } else {
                        break;
                    }
                }
            }
            double money = Double.parseDouble(price);
            if (isValidCustomer && isInt && isValidPrice && isValidProduct) {
                System.out.printf("%s: %s - %.2f", customer,product,productCount * money);
                income += productCount * money;
            }
            input = sc.nextLine();
        }
    }

    private static boolean validateProduct(String product) {
        for (int p = 0; p < product.length(); p++) {
            if (!Character.isAlphabetic(product.charAt(p)) &&
                    !Character.isDigit(product.charAt(p)) &&
                    product.charAt(p) != '_') {
                return false;
            }
        }
        return true;
    }

    private static boolean validateCustomer(String customer) {
        if (Character.isUpperCase(customer.charAt(0))) {
            return false;
        }
        for (int i = 1; i < customer.length(); i++) {
            if (!Character.isLowerCase(customer.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
