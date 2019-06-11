package Generics.GenericListsUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2 , 3, 6, 7 , 9);

        System.out.println(ListUtils.getMax(numbers));

        numbers = new ArrayList<>();
        System.out.println(ListUtils.getMax(numbers));

    }
}
