package EXAMS;

import java.io.*;
import java.util.regex.*;

public class AnimalSanctuary {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^n:([^;]+);t:([^;]+);c--([a-zA-Z ]+)$");
        int weight = 0;
        int n =Integer.parseInt(sc.readLine());
        while (n-- > 0){
            Matcher m = pattern.matcher(sc.readLine());
            if (m.find()){
                StringBuilder name = new StringBuilder();
                for (int i = 0; i < m.group(1).length(); i++) {
                    if (Character.isLetter(m.group(1).charAt(i))){
                        name.append(m.group(1).charAt(i));
                    }else if (Character.isDigit(m.group(1).charAt(i))){
                        weight += Integer.parseInt(String.valueOf(m.group(1).charAt(i)));
                    }

                }

                StringBuilder type = new StringBuilder();
                for (int i = 0; i < m.group(2).length(); i++) {
                    if (Character.isLetter(m.group(2).charAt(i))){
                        type.append(m.group(2).charAt(i));
                    }else if (Character.isDigit(m.group(2).charAt(i))){
                        weight += Integer.parseInt(String.valueOf(m.group(2).charAt(i)));
                    }
                }

                StringBuilder country = new StringBuilder();
                for (int i = 0; i < m.group(3).length(); i++) {
                    if (Character.isLetter(m.group(3).charAt(i))){
                        country.append(m.group(3).charAt(i));
                    }
                }
                System.out.printf("%s is a %s from %s\n",name,type,country);
            }
        }
        System.out.printf("Total weight of animals: %dKG\n",weight);

    }
}
