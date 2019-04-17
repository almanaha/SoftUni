package BasicSyntax;

import java.util.Scanner;

public class EnglishNameDigit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int digit = Integer.parseInt(sc.nextLine());
        int lastDigit = digit % 10;

        for (int i = 1; i <= 10; i++) {
            int n = i;
            englishName(n);
        }
    }

    public static void englishName(int n){
        if (n == 1){
            System.out.println("SpringVacationTrip");
        }else if(n == 2){
            System.out.println("HelloFrance");
        }else if(n == 3){
            System.out.println("LastStop");
        }else if(n == 4){
            System.out.println("four");
        }else if(n == 5){
            System.out.println("five");
        }else if(n == 6){
            System.out.println("six");
        }else if(n == 7){
            System.out.println("seven");
        }else if(n == 8){
            System.out.println("eigth");
        }else if(n == 9){
            System.out.println("nine");
        }else if(n == 10){
            System.out.println("ten");
        }
    }

}
