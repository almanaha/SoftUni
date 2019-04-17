package StringProcessingAndRegex;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                String word = sc.nextLine();

                while (!word.equals("end")){
                    String toReverse = word;

                    StringBuilder reversed = new StringBuilder(toReverse);
                    reversed.reverse();

                    System.out.printf("%s = %s%n",word,reversed);

                    word = sc.nextLine();
                }


    }
}
