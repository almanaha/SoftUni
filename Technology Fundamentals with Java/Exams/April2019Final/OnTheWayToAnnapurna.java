package Exams.April2019Final;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> stores = new LinkedHashMap<>();

        String input;
        while (!"END".equals(input = sc.readLine())) {
            String[] data = input.split("->");
            String store = data[1];
            stores.putIfAbsent(store, new LinkedList<>());
            if (data.length == 3) {
                List<String> items = Arrays.stream(data[2].split(",")).collect(Collectors.toList());
                if (stores.containsKey(store)) {
                    stores.get(store).addAll(items);
                }
            } else {
                if (stores.containsKey(store)) {
                    stores.remove(store);
                }
            }
        }
        System.out.println("Store list:");
        stores.entrySet().stream()
                .sorted((x, y) ->
                        y.getValue().size() == x.getValue().size() ?
                                y.getKey().compareTo(x.getKey()) :
                                Integer.compare(y.getValue().size(), x.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().forEach(i -> System.out.println("<<" + i + ">>"));
                });
    }
}
