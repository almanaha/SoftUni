package List.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = Double.parseDouble(sc.nextLine());

        List<Integer> drumSet = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Double> prices = drumSet.stream().map(d -> d * 3d)
                .collect(Collectors.toList());

        String cmd = sc.nextLine();

        while (!cmd.equals("Hit it again, Gabsy!")){
            int power = Integer.parseInt(cmd);

            for (int i = 0; i < drumSet.size(); i++) {

                if (drumSet.get(i) == Integer.MIN_VALUE){
                    continue;
                }

                drumSet.set(i , drumSet.get(i) - power);

                if (drumSet.get(i) <= 0){
                    double price = prices.get(i);
                    if (money >= price){
                        money -= price;
                        drumSet.set(i, (int)price/3);
                    }else{
                        drumSet.set(i, Integer.MIN_VALUE);
                    }
                }
            }
            cmd = sc.nextLine();
        }
            drumSet.stream()
                .filter(d -> d != Integer.MIN_VALUE)
                .forEach(d -> System.out.print(d + " "));
        System.out.printf("%nGabsy has %.2flv.",money);
    }
}
