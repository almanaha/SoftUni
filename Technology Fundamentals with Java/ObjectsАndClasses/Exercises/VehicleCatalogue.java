package ObjectsАndClasses.Exercises;

import java.util.*;

public class VehicleCatalogue { //Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();

        String command = sc.nextLine();

        while (!command.equals("End")) {

            String[] data = command.split("\\s+");

            Vehicle vehicle = new Vehicle(data[0],
                    data[1], data[2],
                    Integer.parseInt(data[3]));

            if (vehicle.getType().equals("Truck")) {
                trucks.add(vehicle);
            } else {
                cars.add(vehicle);
            }

            command = sc.nextLine();
        }

        command = sc.nextLine();

        while (!command.equals("Close the Catalogue")) {
            for (Vehicle truck : trucks) {
                if (truck.getModel().equals(command)) {
                    System.out.println(truck.toString());
                }
            }
            for (Vehicle car : cars) {
                if (car.getModel().equals(command)) {
                    System.out.println(car.toString());
                }
            }
            command = sc.nextLine();
        }

        double sumHP = 0;

        if (!cars.isEmpty()) {
            for (Vehicle car : cars) {
                sumHP += car.getHorsepower();
            }
            System.out.printf("Cars have average horsepower of: %.2f.%n", sumHP / cars.size());
        }
        sumHP = 0;

        if (!trucks.isEmpty()) {
            for (Vehicle truck : trucks) {
                sumHP += truck.getHorsepower();
            }
            System.out.printf("Trucks have average horsepower of: %.2f.", sumHP / trucks.size());
        }
    }
}

class Vehicle {

    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle(String type, String model, String color, int horsepower) {
        this.setType(type);
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    private void setType(String type) {
        type = type.replace(type.charAt(0), Character.toTitleCase(type.charAt(0)));
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                "Model: %s%n" +
                "Color: %s%n" +
                "Horsepower: %d", this.type, this.model, this.color, this.horsepower);
    }
}

