package StringProcessingAndRegex.Exercises;

import java.util.Scanner;

public class ValidUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] users = sc.nextLine().split(", ");

        for (int i = 0; i < users.length; i++) {
            if (validUser(users[i])) {
                System.out.println(users[i]);
            }
        }
    }

    public static boolean validUser(String user) {
        // Has length between 3 and 16 characters
        if (user.length() < 3 || user.length() > 16) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            char symbol = user.charAt(i);
            // Contains only letters, numbers, hyphens and underscores
            // Has no redundant symbols before, after or in between --> '-'  '_'
            if (!Character.isLetterOrDigit(symbol) && symbol != '-'
                    && symbol != '_') {
                return false;
            }
        }
        return true;
    }
}
