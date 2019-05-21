package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = sc.nextLine().split("\\s+");
        int x = Integer.parseInt(sc.nextLine());

        Deque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);
        int counter = 1;

        while (children.size() > 1) {
            for (int i = 0; i < x - 1; i++) {
                String kid = children.poll();
                children.offer(kid);
            }
            if (isPrime(counter)) {
                String child = children.peek();
                System.out.println("Prime " + child);
            } else {
                String child = children.pop();
                System.out.println("Removed " + child);
            }
            counter++;
        }

        System.out.println("Last is " + children.peek());
    }

    private static boolean isPrime(int x) {
        if (x == 1){
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
