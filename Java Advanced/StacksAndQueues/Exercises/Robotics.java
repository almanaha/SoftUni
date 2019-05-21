package StacksAndQueues.Exercises;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Deque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().split(";");

        String[] robots = new String[data.length];
        int[] workTime = new int[data.length];
        int[] processTime = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            robots[i] = data[i].split("-")[0];
            workTime[i] = Integer.parseInt(data[i].split("-")[1]);
        }

        String[] timeData = sc.nextLine().split(":");
        int hours = Integer.parseInt(timeData[0]);
        int mins = Integer.parseInt(timeData[1]);
        int sec = Integer.parseInt(timeData[2]);


        Deque<String> products = new ArrayDeque<>();

        String product;
        while (!"End".equals(product = sc.nextLine())) {
            products.offer(product);
        }

        int startInSeconds = (hours * 60 * 60) + mins * 60 + sec;
        int time = 0;

        while (!products.isEmpty()) {
            time++;

            String productOnTheLine = products.pollFirst();
            boolean isAssigned = false;

            for (int i = 0; i < robots.length; i++) {
                if (processTime[i] == 0 && !isAssigned) {
                    processTime[i] = workTime[i];
                    print(robots[i], startInSeconds + time, productOnTheLine);
                    isAssigned = true;
                }
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }
            if (!isAssigned) {
                products.offer(productOnTheLine);
            }

        }
    }

    private static void print(String robot, int time, String product) {
        int hours = (time / 60 / 60) % 24;
        int mins = (time / 60) % 60;
        int secs = time % 60;
        DecimalFormat format = new DecimalFormat("00");

        System.out.printf(
                "%s - %s [%s:%s:%s]%n",
                robot,
                product,
                format.format(hours),
                format.format(mins),
                format.format(secs));
    }
}
