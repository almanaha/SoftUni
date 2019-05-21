package IteratorsAndComparators.Exercises.PetClinic;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Clinic> shelters = new HashMap<>();
        Map<String, Pet> pets = new HashMap<>();

        int n = Integer.parseInt(sc.readLine());
        while (n-- > 0) {
            String[] data = sc.readLine().split("\\s+");
            switch (data[0]) {
                case "Create":
                    if (data[1].equals("Pet")) {
                        Pet pet = new Pet(data[2], Integer.parseInt(data[3]), data[4]);
                        pets.putIfAbsent(data[2], pet);
                    } else {
                        try {
                            Clinic clinic = new Clinic(data[2], Integer.parseInt(data[3]));
                            shelters.putIfAbsent(data[2], clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    System.out.println(shelters.get(data[2]).add(pets.get(data[1])));
                    break;
                case "Release":
                    System.out.println(shelters.get(data[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(shelters.get(data[1]).HasEmptyRooms());
                    break;
                case "Print":
                    if (data.length == 2) {
                        //Print {clinic's name}
                        shelters.get(data[1]).forEach(pet -> {
                            if (pet != null){
                                System.out.println(pet);
                            }else{
                                System.out.println("Room empty");
                            }
                        });
                    } else {
                        //Print {clinic's name} {room}

                        System.out.println(shelters.get(data[1])
                                .printRoom(Integer.parseInt(data[2]) - 1));

                    }
                    break;
            }
        }
    }
}
