package List;

import java.util.*;
import java.util.stream.Collectors;

public class ListManipulationBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = sc.nextLine();
        while (!command.equals("end")) {
            String[] data = command.split(" ");
            String cmd = data[0];
            int number = 0;
            int index = 0;

            switch (cmd) {
                case "Add":
                    number = Integer.parseInt(data[1]);
                    list.add(number);
                    break;
                case "Remove":
                    number = Integer.parseInt(data[1]);
                    list.remove(number);
                    break;
                case "RemoveAt":
                    index = Integer.parseInt(data[1]);
                    list.remove(index);
                    break;
                case "Insert":
                    number = Integer.parseInt(data[1]);
                    index = Integer.parseInt(data[2]);
                    list.add(index, number);
                    break;
            }
            command = sc.nextLine();
        }

        for (Integer x : list) {
            System.out.print(x + " ");
        }
    }
}
