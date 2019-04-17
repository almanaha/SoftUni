package Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        if (validPassword(password)){
            System.out.println("Password is valid");
        }
    }

    public static boolean validPassword(String pass) {
        boolean charCount = validateCount(pass);
        boolean onlytLettersAndDigits = validateContain(pass);
        boolean haveTwoDigits = validateTwoDigits(pass);

        return  charCount && onlytLettersAndDigits && haveTwoDigits;
    }

    public static boolean validateCount(String p) {
        boolean isValid = p.length() > 5 && p.length() < 11;

        if (!isValid){
            System.out.println("Password must be between 6 and 10 characters");
            return  false;
        }
        return true;
    }

    public static boolean validateContain(String p) {
        for (int i = 0; i < p.length(); i++) {
            char symbol = p.charAt(i);
            if (!Character.isLetterOrDigit(symbol)) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    public static boolean validateTwoDigits(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            char symbol = p.charAt(i);
            if (Character.isDigit(symbol)){
                count++;
                if (count >= 2){
                    return true;
                }
            }
        }
        System.out.println("Password must have at least 2 digits");
        return false;
    }
}
