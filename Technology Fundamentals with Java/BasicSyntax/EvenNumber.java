package BasicSyntax;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = Integer.parseInt(sc.nextLine());
            if (n % 2 == 0){
                System.out.println("The number is: " + Math.abs(n));
                break;
            }else{
                System.out.println("Please write an even number.");
            }
        }
    }
}
