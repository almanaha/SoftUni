package Generics.GenericArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] strings = ArrayCreator.create(String.class,10,"something");
        Integer[] ints = ArrayCreator.create(10,10);


        int count = 0;
        for (Integer integer : ints) {
            System.out.print(count++ + " " + integer);
        }
    }
}
