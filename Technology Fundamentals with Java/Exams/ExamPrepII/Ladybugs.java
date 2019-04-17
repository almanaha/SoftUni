package Exams.ExamPrepII;

import java.util.*;
import java.util.stream.Collectors;

public class Ladybugs {
    public static ArrayList<Integer> field;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer fieldSize = Integer.parseInt(sc.nextLine());
        field = new ArrayList<>(fieldSize);
        for (int i = 0; i < fieldSize; i++) field.add(0);
        List<Integer> bugsIndexes = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(i -> i >= 0 && i < fieldSize)
                .collect(Collectors.toList());
        for (Integer index : bugsIndexes) {
            field.set(index, 1);
        }

        String input = sc.nextLine();
        while (!input.equals("end")){
            String[] data = input.split("\\s+");
            int ladybugIndex = Integer.parseInt(data[0]);
            String direction = data[1];
            int flyIndex = Integer.parseInt(data[2]);
            int land = ladybugIndex;

            if (direction.equals("left")){
                flyIndex *= -1;
            }
            if (ladybugIndex < 0 || ladybugIndex >= field.size() || field.get(ladybugIndex) == 0){
                continue;
            }

            field.set(ladybugIndex, 0);
            while (true){

                land += flyIndex;

                if (land < 0 || land >= field.size()){
                    break;
                }
                if (field.get(land) == 0){
                    field.set(land, 1);
                    break;
                }
            }
            input = sc.nextLine();
        }

        for (Integer bugs : field) {
            System.out.print(bugs + " ");
        }
    }
}
