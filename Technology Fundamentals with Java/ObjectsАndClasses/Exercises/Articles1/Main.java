package ObjectsАndClasses.Exercises.Articles1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().split(", ");
        int n = Integer.parseInt(sc.nextLine());

        Article article = new Article(data[0],data[1],data[2]);

        while (n-- > 0) {
            String[] command = sc.nextLine().split(": ");
            String cmd = command[0];
            switch (command[0]){
                case "Edit": article.edit(command[1]); break;
                case "ChangeAuthor": article.changeAuthor(command[1]); break;
                case "Rename": article.rename(command[1]); break;
            }
        }
        System.out.println(article.toString());
    }
}
