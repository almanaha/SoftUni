package BasicSyntax;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= 10;i++){
            int product = n * i;
            System.out.printf("%d x %d = %d%n",n,i,product);
        }
    }
}
