package Generics.GenericBox;

public class Box<T extends Comparable<T>> {
    private T element;

    Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName() + ": " + this.element;
    }

    public int compareTo(Box<T> o) {
        return this.element.compareTo(o.element);
    }
}
