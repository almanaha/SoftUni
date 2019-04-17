package Exams.Nov2018Mid;

import java.util.*;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> journal = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("Retire!")){
            String[] data = input.split(" - ");
            String command = data[0];
            String quest = data[1];
            if (command.equals("Start")){
                if (!journal.contains(quest)){
                    journal.add(quest);
                }
            }else if (command.equals("Complete")){
                if (journal.contains(quest)){
                    journal.remove(quest);
                }
            }else if (command.equals("Side Quest")){
                String[] sides = quest.split(":");
                quest = sides[0];
                if (journal.contains(quest)){
                    int index = journal.indexOf(quest);
                    if (journal.contains(sides[1])){
                        input = sc.nextLine();
                        continue;
                    }else{
                        journal.add(index + 1, sides[1]);
                    }
                }
            }else if (command.equals("Renew")){
                if (journal.contains(quest)){
                    int index = journal.indexOf(quest);
                    journal.add(quest);
                    journal.remove(index);
                }
            }
            input = sc.nextLine();
        }

        for (int i = 0; i < journal.size(); i++) {
            if (i == journal.size() - 1){
                System.out.print(journal.get(i));
            }else{
                System.out.print(journal.get(i) + ", ");
            }
        }
    }
}
