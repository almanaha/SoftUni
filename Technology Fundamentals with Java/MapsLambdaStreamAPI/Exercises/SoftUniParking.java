package MapsLambdaStreamAPI.Exercises;

import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> parkingLot = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String[] data = sc.nextLine().split("\\s+");
            String customer = data[1];
            switch (data[0]) {
                case "register":
                    String licensePlate = data[2];
                    if (!parkingLot.containsKey(customer)) {
                        parkingLot.put(customer, licensePlate);
                        System.out.printf("%s registered %s successfully%n", customer, licensePlate);
                    } else {
                        System.out.println("ERROR: already registered with plate number " + licensePlate);
                    }
                    break;
                case "unregister":
                    if (parkingLot.containsKey(customer)) {
                        parkingLot.remove(customer);
                        System.out.println(customer + " unregistered successfully");
                    } else {
                        System.out.println("ERROR: user " + customer + " not found");
                    }
                    break;
            }
        }
        parkingLot.entrySet().forEach(car -> System.out.print(car.getKey() + " => " + car.getValue() + "\n"));
    }
}
