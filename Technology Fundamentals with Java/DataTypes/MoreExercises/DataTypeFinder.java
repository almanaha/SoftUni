package DataTypes.MoreExercises;

import java.util.Scanner;

public class DataTypeFinder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        while (!line.equals("END")) {
            if (line.matches("-?\\d+")) {
                System.out.println(line + " is integer type");
            } else if (line.matches("-?\\d+\\.\\d+")) {
                System.out.println(line + " is floating point type");
            } else if (line.toLowerCase().equals("true") || line.toLowerCase().equals("false")) {
                System.out.println(line + " is boolean type");
            } else if (line.length() == 1) {
                System.out.println(line + " is character type");
            } else {
                System.out.println(line + " is string type");
            }

            line = sc.nextLine();
        }

    }
}
