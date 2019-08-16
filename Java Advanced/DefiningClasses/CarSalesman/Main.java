package DefiningClasses.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int engineCount = Integer.parseInt(sc.nextLine());
        Map<String,Engine> engineMap = new HashMap<>();

        while (engineCount-- > 0){
            String[] data = sc.nextLine().split("\\s+");

            Engine engine = null;
            if (data.length == 2){
                engine= new Engine(data[0],data[1]);
            }else if (data.length == 3){
                engine = new Engine(data[0], data[1]);
                try {
                    Integer.parseInt(data[2]);
                    engine.setDisplacement(data[2]);
                }catch (NumberFormatException e){
                    engine.setEfficiency(data[2]);
                }
            }else{
                engine= new Engine(data[0],data[1],data[2],data[3]);
            }

            engineMap.put(engine.getModel(), engine);
        }
        int carCount = Integer.parseInt(sc.nextLine());

        List<Car> cars = new ArrayList<>();
        while (carCount-- > 0){
            String[] data = sc.nextLine().split("\\s+");

            Car newCar = null;
            Engine current = engineMap.get(data[1]);

            if (data.length == 2){
                newCar= new Car(data[0],current);
            }else if (data.length == 3){
                newCar = new Car(data[0],current);
                try {
                    Integer.parseInt(data[2]);
                    newCar.setWeight(data[2]);
                }catch (NumberFormatException e){
                    newCar.setColor(data[2]);
                }

            }else{
                newCar= new Car(data[0],current,data[2],data[3]);
            }
            cars.add(newCar);
        }

        cars.forEach(s -> System.out.println(s.toString()));

    }
}
