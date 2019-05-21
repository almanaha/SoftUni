package SetsAndMaps.Exercises;

import java.util.*;

public class SerbianUnleashed {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String input = sc.nextLine();
        Map<String, LinkedHashMap<String,Integer>> concerts = new LinkedHashMap<>();

        while (!input.equals("End")){
            if (!input.contains(" @")){
                input = sc.nextLine();
                continue;
            }
            int priceIndex = 0;
            for (int i = input.indexOf("@"); i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i)) && input.charAt(i - 1) == ' '){
                    priceIndex = i;
                    break;
                }
            }

            String[] data = input.substring(priceIndex).split(" ");
            if (data.length != 2){
                input = sc.nextLine();
                continue;
            }
            String singer = input.substring(0,input.indexOf(" @"));
            String venue = input.substring(input.indexOf("@") + 1,priceIndex - 1).trim();
            input = sc.nextLine();

            int price = Integer.parseInt(data[0]);
            int count  = Integer.parseInt(data[1]);

            if (!concerts.containsKey(venue)){
                concerts.put(venue, new LinkedHashMap<String, Integer>(){{
                    put(singer,price * count);
                }});
            }else {
                if (!concerts.get(venue).containsKey(singer)){
                    concerts.get(venue).put(singer,price * count);
                }else {
                    concerts.get(venue).put(singer, concerts.get(venue).get(singer) + price * count);
                }
            }
        }
        concerts.entrySet().forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().entrySet().stream().sorted((e1,e2) ->
                    Integer.compare(e2.getValue(),e1.getValue()))
                    .forEach(x -> {
                        System.out.printf("#  %s -> %d%n",x.getKey(),x.getValue());
                    });
        });
    }
}
