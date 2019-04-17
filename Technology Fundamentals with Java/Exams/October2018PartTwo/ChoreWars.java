package Exams.October2018PartTwo;

import java.util.*;

public class ChoreWars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dishes = 0,
                cleaning = 0,
                laundry = 0;

        String input = sc.nextLine();
        while (!input.equals("wife is happy")){

            if (input.contains("{") && input.contains("}")){
                int start = input.indexOf("{") + 1;
                int end = input.indexOf("}");

                String data = input.substring(start,end);

                for (int i = 0; i < data.length(); i++) {
                    if (Character.isDigit(data.charAt(i))){
                        laundry += data.charAt(i) - '0';
                    }
                }
            }else if (input.contains("<") && input.contains(">")){
                int start = input.lastIndexOf("<") + 1;
                int end = input.indexOf(">");

                String data = input.substring(start,end);
                if (validDishes(data)){
                    for (int i = 0; i < data.length(); i++) {
                        if (Character.isDigit(data.charAt(i))){
                            dishes += data.charAt(i) - '0';
                        }
                    }
                }
            }else if (input.contains("[") && input.contains("]")){
                int start = input.lastIndexOf("[") + 1;
                int end = input.indexOf("]");

                String data = input.substring(start,end);
                if (validateClean(data)){
                    for (int i = 0; i < data.length(); i++) {
                        if (Character.isDigit(data.charAt(i))){
                            cleaning += data.charAt(i) - '0';
                        }
                    }
                }
            }
            input = sc.nextLine();
        }
        System.out.printf("Doing the dishes - %d min.%n",dishes);
        System.out.printf("Cleaning the house - %d min.%n",cleaning);
        System.out.printf("Doing the laundry - %d min.%n",laundry);
        System.out.printf("Total - %d min.%n",dishes + cleaning + laundry);
    }

    private static boolean validateClean(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isUpperCase(data.charAt(i)) && !Character.isDigit(data.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private static boolean validDishes(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isLowerCase(data.charAt(i)) && !Character.isDigit(data.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
