package WorkshopLinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        list.addFirst(8);
        list.addFirst(9);
        list.addFirst(10);
        list.addAfter(7,7777);
        list.addAfter(3,33);
        list.addAfter(2,22);
        list.addLast(99);
        list.addLast(88);
        list.addLast(77);
        list.addLast(66);
        list.addLast(55);
        list.forEach(e-> System.out.print(e + " "));

        list.removeAfter(77);
        list.removeAfter(88);
        list.removeAfter(99);
        list.removeAfter(1);

        System.out.println();
        list.forEach(e-> System.out.print(e + " "));




    }
}
