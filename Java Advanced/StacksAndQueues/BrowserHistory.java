package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String url = s.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String lastUrl = "";

        while (!url.equals("Home")) {
            if (url.equals("back")) {
                if (browserHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                }else {
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            }else{
                System.out.println(url);
                browserHistory.push(url);
            }
            url = s.nextLine();
        }
    }
}
