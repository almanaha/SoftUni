package WorkshopSmartArray;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SmartArray arr = new SmartArray();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(9);
        arr.add(23);

        arr.forEach(e -> System.out.println(e + " "));


    }
}
