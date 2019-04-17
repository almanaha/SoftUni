package Exams.Basics;

public class Print {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if ((i + 1) % 10 == 0) {
                System.out.println("$");
            } else if ((i < 11 || i > 87) ||
                    i % 10 == 0 ||
                    i % 11 == 0 ||
                    i % 9 == 0) {
                System.out.print("$");
            } else {
                System.out.print(" ");
            }
        }
    }
}
