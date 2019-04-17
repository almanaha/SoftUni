package MapsLambdaStreamAPI.MoreExercises;

import java.util.*;

public class MOBA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, TreeMap<String, Integer>> pPS =
                new TreeMap<>();

        String input;
        while (!"Season end".equalsIgnoreCase(input = sc.nextLine().trim())) {

            String[] tokens = input.split("\\s+");
            if (tokens.length > 1) {
                if (tokens.length == 3) {
                    String playerF = tokens[0];
                    String playerS = tokens[2];

                    if (pPS.containsKey(playerF) && pPS.containsKey(playerS)) {
                        for (Map.Entry<String, Integer> kv : pPS.get(playerF).entrySet()) {
                            if (pPS.containsKey(playerF) && pPS.containsKey(playerS)) {


                                for (Map.Entry<String, Integer> ps : pPS.get(playerS).entrySet()) {
                                    if (ps.getKey().contains(kv.getKey())) {
                                        if (ps.getValue() > kv.getValue()) {
                                            pPS.remove(playerF);
                                            break;
                                        } else if (ps.getValue() < kv.getValue()) {
                                            pPS.remove(playerS);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }

                } else if (tokens.length == 5) {
                    String player = tokens[0];
                    String position = tokens[2];
                    @SuppressWarnings("")
                    int skill = Integer.parseInt(tokens[4]);

                    pPS.putIfAbsent(player, new TreeMap<>());

                    if (pPS.get(player).containsKey(position)) {
                        if (pPS.get(player).get(position) < skill) {
                            pPS.get(player).put(position, skill);
                        }
                    } else {
                        pPS.get(player).put(position, skill);
                    }
                }

            }
        }
        TreeMap<String, Integer> usersSkill = new TreeMap<>();

        for (Map.Entry<String, TreeMap<String, Integer>> entry : pPS.entrySet()) {
            for (Map.Entry<String, Integer> kvp : entry.getValue().entrySet()) {
                usersSkill.putIfAbsent(entry.getKey(), 0);

                usersSkill.put(entry.getKey(),
                        usersSkill.get(entry.getKey())
                                + kvp.getValue());
            }
        }

        usersSkill.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .forEach(x -> {
                    System.out.printf("%s: %d skill\n", x.getKey(), x.getValue());
                    pPS.get(x.getKey()).entrySet().stream()
                            .sorted((f, y) -> {
                                        int sort = y.getValue().compareTo(f.getValue());
                                        if (sort == 0) {
                                            sort = f.getKey().compareTo(y.getKey());
                                        }
                                        return sort;
                                    }
                            ).forEach(e -> System.out.printf("- %s <::> %d\n", e.getKey(), e.getValue()));
                });
    }
}
