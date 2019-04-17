package Exams.Oct2018PartOne;

import java.util.*;

public class ChatLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> chat = new ArrayList<>();

        String info = sc.nextLine();
        while (!info.equals("end")){
            String[] data = info.split("\\s+");
            String message = data[1];

            switch (data[0]){
                case "Chat":
                    chat.add(message);
                    break;
                case "Delete":
                    if (chat.contains(message)){
                        chat.remove(message);
                    }
                    break;
                case "Edit":
                    String newVersion = data[2];
                    if (chat.contains(message)){
                        chat.set(chat.indexOf(message),newVersion);
                    }
                    break;
                case "Pin":
                    if (chat.contains(message)){
                        chat.remove(message);
                        chat.add(message);
                    }
                    break;
                case "Spam":
                    List<String> spam = new ArrayList<>();
                    for (int i = 1; i < data.length; i++) {
                        spam.add(data[i]);
                    }
                    chat.addAll(spam);
                    break;
            }
            info = sc.nextLine();
        }

        for (String c : chat) {
            System.out.println(c);
        }

    }
}
