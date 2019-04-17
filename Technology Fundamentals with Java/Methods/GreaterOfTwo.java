package Methods;

import java.util.Scanner;

public class GreaterOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();

        if (type.equals("int"))
        {
            int x = Integer.parseInt(sc.nextLine());
            int y = Integer.parseInt(sc.nextLine());
            int maxValue = GetMax(x, y);
            System.out.println(maxValue);
        }else if (type.equals("char")) {
            char first = sc.nextLine().charAt(0);
            char second = sc.nextLine().charAt(0);
            char maxValue = GetMax(first, second);
            System.out.println(maxValue);
        }else if (type.equals("String")) {
            String first = sc.nextLine();
            String second = sc.nextLine();
            String maxValue = GetMax(first, second);
            System.out.println(maxValue);
        }

    }
    public static String GetMax(String first, String second)
    {
        boolean isMax = first.compareTo(second) >= 0;
        if (isMax) {
            return first;
        }
        return second;
    }
    static char GetMax(char first, char second)
    {
        if (first > second) {
            return first;
        }
        return second;
    }
    static int GetMax(int first, int second)
    {
        if (first > second) {
            return first;
        }
        return second;
    }
}
