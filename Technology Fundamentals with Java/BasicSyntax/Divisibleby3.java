package BasicSyntax;

import java.util.Scanner;

public class Divisibleby3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int number = 1;
        int sum = 0;
        for (int i = 1; i <= n;i++){
            sum += number;
            System.out.println(number);
            number += 2;
        }
        System.out.println("Sum: " + sum);
    }
}
