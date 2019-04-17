package Exams.November2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AnonymousCache {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> data = new LinkedHashMap<>();
        Map<String, Map<String, Long>> cache = new LinkedHashMap<>();

        String line;
        while (!"thetinggoesskrra".equals(line = sc.readLine())) {
            String[] cmd = line.split(" \\| ");
            if (cmd.length == 1) {
                String dataSet = line;
                data.putIfAbsent(dataSet, new LinkedHashMap<>());
                if (cache.containsKey(dataSet)) {
                    Map<String, Long> fromCache = cache.get(dataSet);
                    fromCache.forEach((key, value) -> data.get(dataSet).put(key, value));
                    cache.remove(dataSet);
                }
            } else {
                String[] keys = cmd[0].split(" -> ");

                String dataKey = keys[0];
                long dataSize = Long.parseLong(keys[1]);
                String dataSet = cmd[1];

                if (!data.containsKey(dataSet)) {
                    cache.putIfAbsent(dataSet, new LinkedHashMap<>());
                    cache.get(dataSet).put(dataKey, dataSize);
                } else {
                    data.putIfAbsent(dataSet, new LinkedHashMap<>());
                    data.get(dataSet).put(dataKey, dataSize);
                }
            }
        }

        if (data.size() > 0) {
//            Map.Entry<String, Map<String, Long>> result = data.entrySet().stream().sorted((x, y) -> {
//                long sum1 = x.getValue().values().stream().mapToLong(Long::longValue).sum();
//                long sum2 = y.getValue().values().stream().mapToLong(Long::longValue).sum();
//                return Long.compare(sum2, sum1);
//            }).findFirst().get();
//            long sum = result.getValue().values().stream().mapToLong(Long::longValue).sum();
//            System.out.printf("Data Set: %s, Total Size: %d\n", result.getKey(), sum);
//            result.getValue()
//                    .forEach((key, value) ->
//                            System.out.println("$." + key));

            data.entrySet().stream()
                    .sorted((x, y) -> {
                        long sum1 = x.getValue().values().stream().mapToLong(Long::longValue).sum();
                        long sum2 = y.getValue().values().stream().mapToLong(Long::longValue).sum();
                        return Long.compare(sum2, sum1);
                    })
                    .limit(1)
                    .forEach(e -> {
                        long sum = e.getValue().values().stream().mapToLong(Long::longValue).sum();
                        System.out.printf("Data Set: %s, Total Size: %d\n", e.getKey(), sum);
                        e.getValue()
                                .forEach((key, value) ->
                                        System.out.println("$." + key));
                    });
        }

    }
}
