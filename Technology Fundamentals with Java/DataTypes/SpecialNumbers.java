package DataTypes;
import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        for (int num = 1; num <= n; num++) {
            int sumOfDigits = 0;
            int digits = num;
            int total = 0;
            while (digits > 0) {
                sumOfDigits += digits % 10;
                digits = digits / 10;
            }
            if (sumOfDigits == 5 ||
                    sumOfDigits == 7 ||
                    sumOfDigits == 11){
                System.out.printf("%d -> True",num);
            }else{
                System.out.printf("%d -> False",num);

            }
            System.out.println();

        }
    }
}
