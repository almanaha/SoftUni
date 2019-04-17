package ObjectsАndClasses.Exercises.VehicleCatalog;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Vehicle> cars = new ArrayList<>();

        String input;
        while (!"End".equals(input = sc.nextLine())) {
            String[] data = input.split("\\s+");

            Vehicle vehicle = new Vehicle(data[0],
                    data[1], data[2], Integer.parseInt(data[3]));

            cars.add(vehicle);
        }

        String car = sc.nextLine();
        while (!"Close the Catalogue".equals(car)) {
            String model = car;

            cars.stream().filter(v -> v.getModel().equals(model))
                    .forEach(System.out::println);

            car = sc.nextLine();
        }

        System.out.println(
                String.format("Cars have average horsepower of: %.2f.",
                        avg(cars.stream()
                                .filter(v -> v.getType().equals("car"))
                                .collect(Collectors.toList()))));

        System.out.println(
                String.format("Trucks have average horsepower of: %.2f.",
                        avg(cars.stream()
                                .filter(v -> v.getType().equals("truck"))
                                .collect(Collectors.toList()))));


    }

    private static double avg(List<Vehicle> cars) {
        if (cars.size() == 0) {
            return 0.0;
        }
        double sum = 0;
        for (Vehicle car : cars) {
            sum += car.getHorsepower();
        }
        return sum / cars.size();
    }
}
