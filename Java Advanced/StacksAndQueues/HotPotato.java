package StacksAndQueues;

import java.util.*;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String[] names = sc.nextLine().split("\\s+");
        int x = Integer.parseInt(sc.nextLine());

        Deque<String> children = new ArrayDeque<>();
        Collections.addAll(children,names);

        while (children.size() > 1){
            for (int i = 1; i < x; i++) {
                if (i % 2 == 0){
                    String removed = children.pop();
                    System.out.println("Removed " + removed);
                }else {
                    String kid = children.poll();
                    System.out.println("Prime " + kid);
                    children.offer(kid);
                }
            }
        }
        System.out.println("Last is " + children.peek());
    }
}
