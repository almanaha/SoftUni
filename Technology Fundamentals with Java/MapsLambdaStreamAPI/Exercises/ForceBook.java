package MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> users = new HashMap<>();
        String input = sc.nextLine();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains(" | ")) {
                String[] cmd = input.split(" \\| ");
                String user = cmd[1];
                String side = cmd[0];

                users.putIfAbsent(side, new ArrayList<>());

                boolean exist = false;
                for (Map.Entry<String, List<String>> entry : users.entrySet()) {
                    List<String> names = entry.getValue();
                    if (names.contains(user)) {
                        exist = true;
                        break;
                    }
                }

                if (!exist) {
                    users.get(side).add(user);
                }

            } else if (input.contains(" -> ")) {
                String[] cmd = input.split(" -> ");
                String user = cmd[0];
                String side = cmd[1];
                users.putIfAbsent(side, new ArrayList<>());

                for (Map.Entry<String, List<String>> entry : users.entrySet()) {
                    List<String> names = entry.getValue();
                    if (names.contains(user)) {
                        names.remove(user);
                        break;
                    }
                }

                //change his/her side.
                users.get(side).add(user);
                System.out.printf("%s joins the %s side!%n", user, side);
            }
            input = sc.nextLine();
        }

        // Ordered descending by forceUsers count, than ordered by name.
        // For each side print the forceUsers, ordered by name.
        // In case there are no forceUsers in a side, you shouldn`t print the side information.

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
                    Collections.sort(e.getValue());
                    e.getValue().forEach(u -> System.out.println("! " + u));
                });
    }
}
