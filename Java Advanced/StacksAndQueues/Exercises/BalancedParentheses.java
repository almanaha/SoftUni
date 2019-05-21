package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<String> parantheses = new ArrayDeque<>();
        String[] brackets = sc.nextLine().split("");

        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i].equals("(") ||
                    brackets[i].equals("[") ||
                    brackets[i].equals("{")) {
                parantheses.push(brackets[i]);
            } else {
                if (parantheses.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                String bracket = parantheses.poll();
                if (bracket.equals("(") && brackets[i].equals(")")) {
                    continue;
                } else if (bracket.equals("[") && brackets[i].equals("]")) {
                    continue;
                } else if (bracket.equals("{") && brackets[i].equals("}")) {
                    continue;
                }
                break;
            }
        }
        if (parantheses.isEmpty()) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
