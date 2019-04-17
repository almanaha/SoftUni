package BasicSyntax;
import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        int startDigit = 1;

        while(startDigit <= number){
            startDigit++;
            String strDigits = sc.nextLine();

            int numOfDigits = strDigits.length();
            int digits = Integer.parseInt(strDigits);

            int mainDigit = digits % 10;
            int offSet = (mainDigit - 2) * 3;

            if (mainDigit == 8 || mainDigit == 9){
                offSet++;
            }

            int letterIndex = (offSet + numOfDigits - 1);
            int index = 97 + letterIndex;
            if (digits != 0){
                System.out.print((char)index);
            }else{
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
