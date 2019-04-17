package Exams.ExamPrepI;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(@{6,})|(\\${6,})|(#{6,})|(\\^{6,})");
        Pattern p1 = Pattern.compile("@{6,}");
        Pattern p2 = Pattern.compile("\\${6,}");
        Pattern p3 = Pattern.compile("#{6,}");
        Pattern p4 = Pattern.compile("\\^{6,}");
        String[] tickets = sc.nextLine().split("[,\\s]+");

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("Invalid ticket - invalid ticket");
                continue;
            }
            Matcher matcher = pattern.matcher(ticket);
            if (matcher.find()) {
                Matcher m1 = p1.matcher(ticket);
                Matcher m2 = p2.matcher(ticket);
                Matcher m3 = p3.matcher(ticket);
                Matcher m4 = p4.matcher(ticket);


            } else {
                System.out.printf("No match - \"ticket \"%s\" - no match\"\n",ticket);
            }

        }
    }
}
