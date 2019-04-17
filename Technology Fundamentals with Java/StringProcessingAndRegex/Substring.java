package StringProcessingAndRegex;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String toRemove = sc.nextLine(),
                text = sc.nextLine();
        while (text.contains(toRemove)) {
        text = text.replace(toRemove, "");
        }
        System.out.println(text);

    }
}
