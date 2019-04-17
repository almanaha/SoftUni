package StringProcessingAndRegex.Exercises;

import java.util.*;

public class SoftUniBarIncome3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalIncome = 0;

        String input;
        while (!"end of shift".equals(input = sc.nextLine())) {
            boolean validCustomer = false;
            boolean validProduct = false;
            boolean validInteger = false;
            boolean validPrice = false;

            int productCount = 0;

            int beginPercent = input.indexOf("%");
            int endPercent = input.indexOf("%", beginPercent + 1);
            String customer = "";
            if (beginPercent != -1 && endPercent != -1) {
                customer = input.substring(beginPercent + 1, endPercent);
                validCustomer = isValidCustomer(customer);
            }

            int beginDiamong = input.indexOf("<");
            int endDiamond = input.indexOf(">", beginDiamong + 1);
            String product = "";
            if (beginDiamong != -1 && endDiamond != -1) {
                product = input.substring(beginDiamong + 1, endDiamond);
                validProduct = isValidProduct(product);
            }

            int beginPipe = input.indexOf("|");
            int endPipe = input.indexOf("|", beginPipe + 1);
            if (beginPipe != -1 && endPipe != -1) {
                String count = input.substring(beginPipe + 1, endPipe);

                try {
                    productCount = Integer.parseInt(count);
                    validInteger = true;
                } catch (Exception e) {
                    validInteger = false;
                }
            }

            String priceStr = "";
            double price = 0;
            int dollarIndex = input.indexOf("$");
            if (dollarIndex != -1) {
                validPrice = true;
                for (int i = dollarIndex - 1; i >= 0; i--) {
                    if (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.') {
                        priceStr = input.charAt(i) + priceStr;
                    } else {
                        break;
                    }
                }
                price = Double.parseDouble(priceStr);
            }

            if (validCustomer && validInteger && validPrice && validProduct){
                totalIncome += productCount * price;
                System.out.printf("%s: %s - %.2f\n",customer,product,productCount * price);
            }
        }
        System.out.printf("Total income: %.2f\n",totalIncome);
    }

    private static boolean isValidProduct(String product) {
        for (int i = 0; i < product.length(); i++) {
            if (!Character.isAlphabetic(product.charAt(i)) &&
                    !Character.isDigit(product.charAt(i)) &&
                    product.charAt(i) != '_') {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCustomer(String customer) {
        if (!Character.isUpperCase(customer.charAt(0))) {
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
