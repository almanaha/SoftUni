package Generics.GenericListsUtils;
import java.util.*;
import java.util.stream.Collectors;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

        List<T> collect = list.stream().sorted().collect(Collectors.toList());
        return collect.get(collect.size() - 1);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

        T max = list.get(0);

        if (list.size() == 1){
            return list.get(0);
        }

        for (int i = 1; i < list.size(); i++) {
            T element = list.get(i);

            if (max.compareTo(element) < 0){
                max = element;
            }
        }
        return max;
    }
}
