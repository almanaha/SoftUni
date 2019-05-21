package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String line = sc.nextLine();

        Deque<Integer> brackets = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '('){
                brackets.push(i);
            } else if (line.charAt(i) == ')'){
                int startIndex = brackets.pop();
                System.out.println(line.substring(startIndex,i + 1));
            }
        }
    }
}
