package DataTypes.MoreExercises;
import java.util.Scanner;

public class DataTypeFinderTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.equals("END")) break;

            if (line.length() == 1 && !Character.isDigit(line.charAt(0))) {
                System.out.println(line + " is character type");
                continue;
            }

            if (line.equalsIgnoreCase("true") || line.equalsIgnoreCase("false")) {
                System.out.println(line + " is boolean type");
                continue;
            }

            boolean isInt = true;
            boolean isFloat = true;

            if (line.charAt(0) != '-' && !Character.isDigit(line.charAt(0))) {
                isInt = false;
                isFloat = false;
            }
            boolean hasDots = false;
            for (int i = 1; i < line.length(); i++)
                if (!Character.isDigit(line.charAt(i))) {
                    isInt = false;
                    if (line.charAt(i) != '.' || hasDots) {
                        isFloat = false;
                    } else {
                        hasDots = true;
                    }
                }

            if (isInt) {
                System.out.println(line + " is integer type");
            } else  if (isFloat) {
                System.out.println(line + " is floating point type");
            } else {
                System.out.println(line + " is string type");
            }
        }

    }
}
