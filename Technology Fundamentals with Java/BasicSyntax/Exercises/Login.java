package BasicSyntax.Exercises;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = "";
        for (int i = username.length() - 1; i >= 0;i--){
            password += username.charAt(i);
        }
        int counter = 1;
        String newPassword = sc.nextLine();

        while (!newPassword.equals(password)){
                counter++;
                System.out.println("Incorrect password. Try again.");
                newPassword = sc.nextLine();
            if (counter == 4){
                break;
            }
        }
        if (newPassword.equals(password)){
            System.out.printf("User %s logged in.",username);
        }else{
            System.out.printf("User %s blocked!",username);
        }
    }
}