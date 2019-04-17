package Methods;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());

        String full = ReapeatedString(str,n);
        System.out.println(full);
    }
    public static String ReapeatedString(String str,int n) {
        String full = "";
        for (int i = 0; i < n; i++) {
            full += str;
        }
        return  full;
    }
}
