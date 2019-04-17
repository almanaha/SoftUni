package BasicSyntax.Exercises;

import java.util.Scanner;

public class Padawan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = Double.parseDouble(sc.nextLine());
        int countStudents = Integer.parseInt(sc.nextLine());
        double lightsabersPrice = Double.parseDouble(sc.nextLine());
        double robesPrice = Double.parseDouble(sc.nextLine());
        double beltsPrice = Double.parseDouble(sc.nextLine());

        int freeBelts = (int) Math.floor(countStudents / 6.0);
        double moneyBelts = beltsPrice * (countStudents - freeBelts);
        double extraSabers = Math.ceil(countStudents * 0.1);
        double moneySabers = (countStudents + extraSabers) * lightsabersPrice;
        double moneyRobes = countStudents * robesPrice;
        double total = moneySabers + moneyRobes + moneyBelts;

        if (total <= money){
            System.out.printf("The money is enough - it would cost %.2flv.",total);
        }else{
            System.out.printf("Ivan Cho will need %.2flv more.",total-money);
        }
    }
}
