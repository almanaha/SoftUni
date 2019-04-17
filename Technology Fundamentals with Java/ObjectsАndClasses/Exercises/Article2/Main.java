package ObjectsАndClasses.Exercises.Article2;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Article> articles = new ArrayList<>();

        while (n-- > 0) {
            String[] data = sc.nextLine().split(", ");
            Article article = new Article(data[0],data[1],data[2]);
            articles.add(article);
        }

        String filter = sc.nextLine();

        switch (filter){
            case "title":
                articles.stream()
                        .sorted(Comparator.comparing(Article::getTitle))
                        .forEach(e -> System.out.println(e.toString()));
                break;
            case "content":
                articles.stream()
                        .sorted(Comparator.comparing(Article::getContent))
                        .forEach(e -> System.out.println(e.toString()));
                break;
            case "author":
                articles.stream()
                        .sorted(Comparator.comparing(Article::getAuthor))
                        .forEach(e -> System.out.println(e.toString()));
                break;
        }
    }
}

