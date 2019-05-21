package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = Integer.parseInt(sc.nextLine());

        StringBuilder text = new StringBuilder();

        Deque<StringBuilder> stack = new ArrayDeque<>();

        while (x-- > 0){
            String[] cmd = sc.nextLine().split("\\s+");
            String command = cmd[0];
            if (command.equals("1")){
                text.append(cmd[1]);
                stack.push(new StringBuilder(text));
            }else if (command.equals("2")){
                int count = Integer.parseInt(cmd[1]);
                int start = text.length() - count;
                text.delete(start,start + count);
                stack.push(new StringBuilder(text));
            }else if (command.equals("3")){
                System.out.println(text.charAt(Integer.parseInt(cmd[1]) - 1));
            }else if (command.equals("4")){
                if (stack.size() > 1) {
                    stack.pop();
                    text = stack.peek();
                }else if (stack.size() == 1){
                    text = new StringBuilder();
                }
            }
        }
    }
}
