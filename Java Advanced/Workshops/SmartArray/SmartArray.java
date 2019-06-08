package WorkshopSmartArray;

import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private static final int GROW = 2;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public int size() {
        return this.size;
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            this.grow();
        }
        this.data[this.size++] = element;
    }

    private void grow() {
        this.capacity *= GROW;
        int[] newData = new int[this.capacity];
        System.arraycopy(this.data,0,newData,0,this.size);
        this.data = newData;
    }

    public int removeAt(int index) {
        if (index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException(
                    "Remove called for index " + index +
                            ". For SmartArray with size " + this.size);
        }

        int remove = this.data[index];

        this.shiftLeft(index);
        this.data[this.size - 1] = 0;
        this.size--;

        if (this.size <= this.capacity / 4){
            this.shrink();
        }

        return remove;
    }

    private void shrink() {
        this.capacity = this.capacity / 2;
        int[] newData = new int[this.capacity];

        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }

        this.data = newData;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
    }

    public void insertAt(int index, int element){
        if (index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException(
                    "Insert called for index " + index +
                            ". For SmartArray with size " + this.size);
        }

        if (index == this.size - 1) {
            int temp = this.data[this.size - 1];
            this.data[this.size - 1] = element;
            this.add(temp);
        }else{
            if (this.size == this.capacity){
                this.grow();
            }
            this.shiftRight(index);
            this.data[index] = element;
            this.size++;
        }

    }

    private void shiftRight(int index) {
        for (int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    boolean contains(int element){
        return Arrays.stream(this.data)
                .limit(this.size)
                .anyMatch(e -> e == element);
    }

    public void forEach(Consumer<Integer> consumer){
        Arrays.stream(this.data)
                .limit(this.size)
                .forEach(consumer::accept);
    }

    public int get(int index){
        if (index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException(
                    "Get called for invalid index " + index +
                            ". For SmartArray with size " + this.size);
        }

        return this.data[index];
    }

}
