package MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class ForceBookTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Set<String>> users = new HashMap<>();
        Map<String, String> sides = new HashMap<>();
        String input = sc.nextLine();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains(" | ")) {

                String[] cmd = input.split(" \\| ");
                String user = cmd[1];
                String side = cmd[0];
                users.putIfAbsent(side, new TreeSet<>());
                if(!sides.containsKey(user)){
                    users.get(side).add(user);
                    sides.putIfAbsent(user,side);
                }else {
                    users.get(side).add(user);
                }

            } else if (input.contains(" -> ")) {
                String[] cmd = input.split(" -> ");
                String user = cmd[0];
                String side = cmd[1];
                users.putIfAbsent(side, new TreeSet<>());

                users.get(side).add(user);
                String oldSide = sides.get(user);
                if (oldSide != null) {
                    users.get(oldSide).remove(user);
                }
                sides.put(user, side);

                System.out.printf("%s joins the %s side!%n", user, side);
            }
            input = sc.nextLine();
        }
        users.entrySet().stream()
                .sorted((e1, e2) -> {
                    int count2 = e2.getValue().size();
                    int count1 = e1.getValue().size();
                    if (count1 == count2) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return Integer.compare(count2, count1);
                })
                .forEach(e -> {
                    if (e.getValue().size() == 0) {
                        return;
                    }
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().forEach(u -> System.out.println("! " + u));
                });
    }
}

