package Generics.CustomList;
import java.util.*;
import java.util.function.Consumer;

public class SmartList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> data;

    public SmartList() {
        this.data = new ArrayList<>();
    }

    public void add(T element){
        this.data.add(element);
    }
    public T remove(int index){
        return this.data.remove(index);
    }
    public boolean contains(T element){
        return this.data.contains(element);
    }
    public void swap(int fIndex, int sIndex){
        T temp = this.data.get(fIndex);
        this.data.set(fIndex, this.data.get(sIndex));
        this.data.set(sIndex, temp);
    }
    public int greaterThan(T element){
        return this.data.stream().filter(e -> e.compareTo(element) > 0)
                .toArray().length;
    }
    public T getMax(){
        return this.data.stream().max(T::compareTo).get();
    }
    public T getMin(){
        return this.data.stream().min(T::compareTo).get();
    }
    public int size(){
        return this.data.size();
    }
    public T get(int index){
        return this.data.get(index);
    }

//    @Override
//    public Iterator<T> iterator() {
//        return this.data.iterator();
//    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
