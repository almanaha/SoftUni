package Generics.GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {


    static <T> T[] create(int length, T items) {
        Object[] result = new Object[length];

        result = setValue(length, items, result);

        return (T[]) result;

    }

    private static <T> T[] setValue(int length, T items, T[] result) {
        for (int i = 0; i < length; i++) {
            result[i] = items;
        }
        return result;
    }

    static <T> T[] create(Class<T> clazz, int length, T items) {
        T[] result = (T[]) Array.newInstance(clazz, length);

        setValue(length, items, result);

        return result;
    }

}
