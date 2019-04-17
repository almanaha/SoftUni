package Exams.Basics;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());

        int firstDigit = number / 100;
        int secondDigit = (number / 10) % 10;
        int thirdDigit = number % 10;

        int start = firstDigit + secondDigit;
        int end = firstDigit + thirdDigit;

        for (int i = 0; i < start; i++) {
            for (int j = 0; j < end; j++) {
                if (number % 5 == 0){
                    number -= firstDigit;
                    System.out.print(number + " ");
                }else if (number % 3 == 0){
                    number -= secondDigit;
                    System.out.print(number + " ");
                }else{
                    number += thirdDigit;
                    System.out.print(number + " ");
                }
            }
            System.out.println();
        }
    }
}
