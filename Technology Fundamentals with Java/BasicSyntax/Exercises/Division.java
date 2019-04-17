package BasicSyntax.Exercises;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int divisor = 0;
        if (n % 2 == 0){
            divisor = 2;
        }
        if (n % 3 == 0){
            divisor = 3;
        }
        if (n % 6 == 0){
            divisor = 6;
        }
        if (n % 7 == 0){
            divisor = 7;
        }
        if (n % 10 == 0){
            divisor = 10;
        }
        if (divisor == 0){
            System.out.println("Not divisible");
        }else{
        System.out.println("The number is divisible by " + divisor);
        }
    }
}
