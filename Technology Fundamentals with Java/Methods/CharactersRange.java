package Methods;

import java.util.Scanner;

public class CharactersRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char first = sc.nextLine().charAt(0);
        char second = sc.nextLine().charAt(0);

        if (second < first){
            printRange(second,first);
        }else{
            printRange(first,second);
        }
    }

    public static void printRange(char f,char s) {
        f++;
        for (char i = f; i < s; i++) {
            System.out.print(i + " ");
        }
    }
}
