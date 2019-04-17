package StringProcessingAndRegex.MoreExercises;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        System.out.println("<h1>");
        System.out.println(input);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println(sc.nextLine());
        System.out.println("</article>");
        while (!"end of comments".equals(input = sc.nextLine())){
            System.out.println("<div>");
            System.out.println(input);
            System.out.println("</div>");
        }
    }
}
