package Generics.GenericScale;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scale<Integer> scale = new Scale<>(15,7);

        System.out.println(scale.getHeavier());
    }
}

