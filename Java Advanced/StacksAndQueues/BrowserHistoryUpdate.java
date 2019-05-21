package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<String> browserHistory = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();

        String url;
        String current = "";
        while (!"Home".equals(url = sc.nextLine())) {
            if (url.equals("back")) {
                if (browserHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    forward.push(current);
                    current = browserHistory.pop();
                }
            } else if (url.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    browserHistory.push(current);
                    current = forward.pop();
                }
            } else {
                if (current.equals("")) {
                    browserHistory.push(current);
                    if (!forward.isEmpty()){
                        forward.clear();
                    }
                }
                current = url;
            }
            System.out.println(current);
        }

    }
}
