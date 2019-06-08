package WorkshopLinkedList;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.function.Consumer;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int element) {
        Node node = new Node(element);

        if (this.isEmpty()) {
            this.tail = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
        }
        this.head = node;
        this.size++;
    }

    public void addLast(int element) {
        Node node = new Node(element);

        if (this.isEmpty()) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
        this.size++;
    }

    public int removeFirst() {
        if (this.isEmpty()) {
            throw new InvalidDnDOperationException
                    ("Remove called for collection with size 0");
        }
        Node deleted = this.head;

        this.head = this.head.next;
        deleted.next = null;

        if (this.size == 1) {
            this.tail = null;
        } else {
            this.head.prev = null;
        }

        this.size--;
        return deleted.value;
    }

    public int removeLast() {
        if (this.isEmpty()) {
            throw new InvalidDnDOperationException(
                    "Remove called for collection with size 0");
        }
        Node deleted = this.tail;

        this.tail = this.tail.prev;
        deleted.prev = null;

        if (this.size == 1) {
            this.head = null;
        } else {
            this.tail.next = null;
        }

        this.size--;
        return deleted.value;
    }

    public void forEach(Consumer<Integer> consumer){
        Node node = this.head;

        while (node.next != null){
            consumer.accept(node.value);

            node = node.next;
        }
    }

    public int[] toArray(){
        int[] result = new int[this.size];
        int index = 0;

        Node node = this.head;
        while (node != null){
            result[index++] = node.value;
            node = node.next;
        }
        return result;
    }

    public void addAfter(int searchElement, int newElement){
        if (this.isEmpty()) {
            throw new InvalidDnDOperationException
                    ("addAfter on empty List");
        }

        Node current = this.head;
        while (current != null ){
            if (current.value == searchElement){
                Node node = new Node(newElement);

                node.next = current.next;
                node.prev = current;

                if (current.next != null){
                    node.next.prev = node;
                }else{
                    this.tail = node;

                }
                current.next = node;

                this.size++;
                return;
            }
            current = current.next;
        }
        throw new InvalidDnDOperationException("Search element not found");
    }

    public int removeAfter(int searchElement){
        if (this.isEmpty()) {
            throw new InvalidDnDOperationException
                    ("addAfter on empty List");
        }

        Node current = this.head;
        while (current != null ){
            if (current.value == searchElement){
                Node delete = current.next;

                if (delete == null){
                    throw new InvalidDnDOperationException
                            ("No element after search element");
                }

                current.next = delete.next;

                if (current.next == null){
                    this.tail = current;
                }else {
                    current.next.prev = current;
                }

                delete.next = null;
                delete.prev = null;

                return delete.value;
            }
            current = current.next;
        }
        throw new InvalidDnDOperationException("Search element not found");

    }


    public boolean isEmpty() {
        return this.size == 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
