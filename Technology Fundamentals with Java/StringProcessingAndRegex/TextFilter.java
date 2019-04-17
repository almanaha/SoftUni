package StringProcessingAndRegex;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] banWords = sc.nextLine().split(", ");

        String text = sc.nextLine();

        for (String banWord : banWords) {
            String star = banWord.replaceAll(".", "*");
            text = text.replace(banWord,star);
        }
        System.out.println(text);
    }
}
