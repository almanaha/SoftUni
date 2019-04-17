package BasicSyntax;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        int price = 0;
        if (day.equals("Weekday")){
            if (age >= 0 && age <= 18){
                price = 12;
            }else if (age > 18 && age <= 64){
                price = 18;
            }else if (age > 64 && age <= 122){
                price = 12;
            }
        }else if (day.equals("Weekend")){
            if (age >= 0 && age <= 18){
                price = 15;
            }else if (age > 18 && age <= 64){
                price = 20;
            }else if (age > 64 && age <= 122){
                price = 15;
            }
        }else if (day.equals("Holiday")){
            if (age >= 0 && age <= 18){
                price = 5;
            }else if (age > 18 && age <= 64){
                price = 12;
            }else if (age > 64 && age <= 122)
                price = 10;
            }
        if (price > 0){
            System.out.println(price + "$");
        }else{
            System.out.println("Error!");
        }

    }
}
