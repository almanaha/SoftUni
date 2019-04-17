package BasicSyntax;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int n2 = Integer.parseInt(sc.nextLine());

        if (n2 <= 10){
        for (int i = n2; i <= 10;i++){
            int product = n * i;
            System.out.printf("%d X %d = %d%n",n,i,product);
        }
        }else{
            int product = n * n2;
            System.out.printf("%d X %d = %d%n",n,n2,product);
        }
}
}