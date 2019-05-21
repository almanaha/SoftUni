package IteratorsAndComparators.Exercises.ListIter;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        this.index = 0;
    }

    public boolean move() {
        if (this.index < this.data.size() - 1){
            this.index++;
            return true;
        }
        return false;
    }

    public String print(){
        if (this.data.size() == 0){
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }

        return this.data.get(this.index);
    }

    public boolean hasNext(){
        return this.index < this.data.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return this.data.iterator();
    }
}
