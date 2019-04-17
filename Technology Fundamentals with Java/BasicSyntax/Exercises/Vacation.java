package BasicSyntax.Exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = Integer.parseInt(sc.nextLine());
        String typeOfGroup = sc.nextLine();
        String day = sc.nextLine();
        double price = 0;
        if (typeOfGroup.equals("Students")){
            if (day.equals("Friday")){
                price = 8.45;
            }else if (day.equals("Saturday")){
                price = 9.80;
            }else if (day.equals("Sunday")){
                price = 10.46;
            }
        }else if (typeOfGroup.equals("Business")){
            if (day.equals("Friday")){
                price = 10.90;
            }else if (day.equals("Saturday")){
                price = 15.60;
            }else if (day.equals("Sunday")){
                price = 16;
            }
        }else if (typeOfGroup.equals("Regular")){
            if (day.equals("Friday")){
                price = 15;
            }else if (day.equals("Saturday")){
                price = 20;
            }else if (day.equals("Sunday")){
                price = 22.50;
            }
        }
        double totalPrice = 0;
        if (group >= 30 && typeOfGroup.equals("Students")){
            totalPrice = (group * price) * 0.85;
        }else if (group >= 100 && typeOfGroup.equals("Business")){
            totalPrice = (group - 10) * price;
        }else if ((group >= 10 && group <= 20) && typeOfGroup.equals("Regular")){
            totalPrice = (group * price) * 0.95;
        }else {
            totalPrice = group * price;
        }
        System.out.printf("Total price: %.2f",totalPrice);
}
}

