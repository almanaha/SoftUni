package Exams.Dec2018Mid;

import java.util.*;
import java.util.stream.Collectors;

public class SantasList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> kids = Arrays.stream(sc.nextLine().split("&"))
                .collect(Collectors.toList());


        String cmd = sc.nextLine();
        while (!cmd.equals("Finished!")) {
            String[] data = cmd.split("\\s+");
            String command = data[0];
            String name = data[1];

            switch (command){
                case "Bad":
                    if (!kids.contains(name)) {
                        kids.add(0, name);
                    }
                    break;
                case "Good":
                    if (kids.contains(name)){
                        kids.remove(name);
                    }
                    break;
                case "Rename":
                    if (kids.contains(name)){
                        int index = kids.indexOf(name);
                        String swap = data[2];
                        kids.set(index, swap);
                    }
                    break;
                case "Rearrange":
                    if (kids.contains(name)){
                        int index = kids.indexOf(name);
                        kids.remove(index);
                        kids.add(name);
                    }
                    break;
            }
            cmd = sc.nextLine();
        }

        for (int i = 0; i < kids.size(); i++) {
            if (i == kids.size() - 1){
                System.out.print(kids.get(i));
            }else{
                System.out.print(kids.get(i) + ", ");
            }
        }
    }
}
