package Methods;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double grade = Double.parseDouble(sc.nextLine());
        StudentGrade(grade);
    }

    public static void  StudentGrade(double n){
        if (n >= 2.00 && n <= 2.99) System.out.println("Fail");
        if (n >= 3.00 && n <= 3.49) System.out.println("Poor");
        if (n >= 3.50 && n <= 4.49) System.out.println("Good");
        if (n >= 4.50 && n <= 5.49) System.out.println("Very good");
        if (n >= 5.50 && n <= 6.00) System.out.println("Excellent");
    }
}
