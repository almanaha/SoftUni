package Methods;
import java.util.Scanner;

public class MiddleChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(printMiddleLetters(str));
    }

    public static String printMiddleLetters(String str) {
        int index = str.length() / 2;
        String letter = "";

        if (str.length() % 2 == 0){
            letter += str.charAt(index - 1);
            letter += str.charAt(index);
        }else{
            letter += str.charAt(index);
        }
        return letter;
    }
}
