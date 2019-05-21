package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<String> printer = new ArrayDeque<>();

        String line;
        while (!"print".equals(line = sc.nextLine())) {

            if (line.equals("cancel")) {
                if (printer.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printer.poll());
                }
            } else {
                printer.offer(line);
            }
        }

        printer.forEach(System.out::println);
//        while (!printer.isEmpty()){
//            System.out.println(printer.poll());
//        }
    }
}
