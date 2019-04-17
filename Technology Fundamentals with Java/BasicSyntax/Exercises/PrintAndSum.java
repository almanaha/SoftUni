package BasicSyntax.Exercises;

import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int n2 = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = n; i <= n2;i++){
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println();
        System.out.println("Sum: " + sum);
    }
}