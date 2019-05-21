package SetsAndMaps.Exercises;

import java.util.*;

public class UserAggregator {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        Map<String, TreeSet<String>> nameAndIp = new TreeMap<>();
        Map<String, Integer> nameAndDuration = new HashMap<>();

        int n = Integer.parseInt(sc.nextLine());

        while (n-- != 0) {
            String[] data = sc.nextLine().split(" ");
            String ip = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);

            nameAndIp.putIfAbsent(user, new TreeSet<>());
            nameAndIp.get(user).add(ip);

            nameAndDuration.putIfAbsent(user, 0);
            nameAndDuration.put(user, nameAndDuration.get(user) + duration);
        }

        for (Map.Entry<String, TreeSet<String>> user : nameAndIp.entrySet()) {
            System.out.println(user.getKey() + ": " + nameAndDuration.get(user.getKey()) + " " + user.getValue());
        }
    }
}
