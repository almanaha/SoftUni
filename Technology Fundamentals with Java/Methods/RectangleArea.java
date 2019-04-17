package Methods;

import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = Double.parseDouble(sc.nextLine());
        double y = Double.parseDouble(sc.nextLine());
        double area = CalculateArea(x,y);
        System.out.println(area);


    }

    public static double CalculateArea(double x,double y) {
        return x * y;
    }
}
