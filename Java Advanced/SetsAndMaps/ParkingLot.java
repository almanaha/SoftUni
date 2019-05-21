package SetsAndMaps;
import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        HashSet<String> parkingLot = new HashSet<>();

        String command;
        while (!"END".equals(command = sc.nextLine())){
            String[] cmd = command.split(", ");
            String car = cmd[1];

            if (cmd[0].equals("IN")){
                parkingLot.add(car);
            }else{
                parkingLot.remove(car);
            }
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }

    }
}
