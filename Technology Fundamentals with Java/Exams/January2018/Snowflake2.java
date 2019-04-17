package Exams.January2018;
import java.util.*;
import java.util.regex.*;

public class Snowflake2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder line = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            line.append(sc.nextLine()).append("\n");
        }
        String pattern = "^([^A-Za-z0-9]+)\n([0-9_]+)\n([^A-Za-z0-9]+)([0-9_]+)(?<core>[A-Za-z]+)([0-9_]+)([^A-Za-z0-9]+)\n([0-9_]+)\n([^A-Za-z0-9]+)\n$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line.toString());
        if (m.matches()){
            System.out.println("Valid");
            System.out.println(m.group("core").length());
        }else{
            System.out.println("Invalid");
        }
    }
}
