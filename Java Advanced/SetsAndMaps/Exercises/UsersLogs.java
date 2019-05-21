package SetsAndMaps.Exercises;

import java.util.*;

public class UsersLogs {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        String input = sc.nextLine();

        while (!input.equals("end")) {
            String username = input.substring(input.lastIndexOf("=") + 1);
            String ip = input.substring(input.indexOf("=") + 1, input.indexOf(" "));

            if (!userLogs.containsKey(username)) {
                userLogs.put(username, new LinkedHashMap<String, Integer>() {{
                    put(ip, 1);
                }});
            } else {
                if (!userLogs.get(username).containsKey(ip)){
                    userLogs.get(username).put(ip,1);
                }else{
                    userLogs.get(username).put(ip,userLogs.get(username).get(ip) + 1);
                }
            }
            input = sc.nextLine();
        }

        for (String id : userLogs.keySet()) {
            System.out.printf("%s: %n",id);
            int size = userLogs.get(id).keySet().size() - 1;

            for (String ip : userLogs.get(id).keySet()) {
                if (size != 0){
                    System.out.printf("%s => %d, ",ip,userLogs.get(id).get(ip));
                }else{
                    System.out.printf("%s => %d.%n",ip,userLogs.get(id).get(ip));
                }
                size--;
            }
        }
    }
}
