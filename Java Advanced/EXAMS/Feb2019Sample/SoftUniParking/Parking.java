package EXAMS.Feb2019Sample.SoftUniParking;

import java.util.*;

public class Parking {
    private Map<String, Car> parking;
    private int capacity;

    Parking(int capacity) {
        this.parking = new HashMap<>();
        this.capacity = capacity;
    }

    String addCar(Car car){
        if (this.parking.containsKey(car.getRegistrationNumber())){
            return "Car with that registration number, already exists!";
        }else if (this.parking.size() == this.capacity){
            return "Parking is full!";
        }

        this.parking.putIfAbsent(car.getRegistrationNumber(), car);
        return "Successfully added new car " + car.getMake() + " " +car.getRegistrationNumber();
    }


    String removeCar(String registrationNumber){
        if (!this.parking.containsKey(registrationNumber)){
            return "Car with that registration number, doesn't exists!";
        }
        this.parking.remove(registrationNumber);
        return "Successfully removed " + registrationNumber;
    }

    Car getCar(String registrationNumber){

        return this.parking.get(registrationNumber);
    }

    void removeSetOfRegistrationNumber(List<String> registrationNumber){

        for (String s : registrationNumber) {
            this.removeCar(s);
        }
    }

    public int getCount(){
        return this.parking.size();
    }
}
