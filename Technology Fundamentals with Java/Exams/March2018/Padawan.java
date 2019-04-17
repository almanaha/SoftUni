package Exams.March2018;

import java.util.*;

public class Padawan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double money = Double.parseDouble(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());
        double lightsabersPrice = Double.parseDouble(sc.nextLine());
        double robesPrice = Double.parseDouble(sc.nextLine());
        double beltsPrice = Double.parseDouble(sc.nextLine());

        double lightsabers = lightsabersPrice* Math.ceil(students * 1.1);
        double robes = robesPrice * students;

        double belts = 0;
        if (students >= 6){
            students -= students / 6; // every 6 belt is free
            belts = students * beltsPrice;
        }else{
            belts = students * beltsPrice;
        }
        double total = lightsabers + robes + belts;

        if (money >= total){
            System.out.printf("The money is enough - it would cost %.2flv.",total);
        }else{
            System.out.printf("Ivan Cho will need %.2flv more.",total - money);
        }

    }
}
