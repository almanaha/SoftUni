package SetsAndMaps.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsers {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int n = Integer.parseInt(sc.nextLine());

        Set<String> users = new LinkedHashSet<>();

        while (n-- > 0){
            String username = sc.nextLine();
            users.add(username);
        }
        for (String user : users) {
            System.out.println(user);
        }

    }
}
