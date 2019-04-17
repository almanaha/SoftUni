package ObjectsАndClasses.Exercises;

import java.util.Scanner;

class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String newContent) {
        this.content = newContent;
    }

    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void rename(String newTitle) {
        this.title = newTitle;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", this.title, this.content, this.author);
    }

}

public class Articles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().split(" ");

        Article articles = new Article(data[0], data[1], data[2]);

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] command = sc.nextLine().split(": +");
            String cmd = command[0];
            if (cmd.equals("Edit")) {
                articles.edit(command[1]);
            } else if (cmd.equals("ChangeAuthor")) {
                articles.changeAuthor(command[1]);
            } else if (cmd.equals("Rename")) {
                articles.rename(command[1]);
            }
        }

        System.out.println(articles.toString());
    }
}
