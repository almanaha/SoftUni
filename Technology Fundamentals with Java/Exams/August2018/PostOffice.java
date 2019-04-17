package Exams.August2018;

import java.util.*;

public class PostOffice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().split("\\|");
        String text1 = data[0];
        String text2 = data[1];
        String[] words = data[2].split(" ");

        String capitalLetter = "";

        //find capital letters
        for (int i = 0; i < text1.length(); i++) {
            char symbol = text1.charAt(i);
            if (symbol == '#' || symbol == '$' || symbol == '%' ||
            symbol == '*' || symbol == '&'){
                int index = text1.indexOf(symbol, i + 1); // ако не го намери , връща - 1
                if (index != -1){
                   capitalLetter = text1.substring(i + 1,index);
                }
            }
        }

        // find ascii code of capital letter
        for (int i = 0; i < capitalLetter.length(); i++) {
            String asciiCode = (int)capitalLetter.charAt(i) + "";

            int index = text2.indexOf(asciiCode);
            int length = 0;
            while (index != -1){
                char firstSymbol = text2.charAt(index + 3);
                char secondSymbol = text2.charAt(index + 4);

                if (Character.isDigit(firstSymbol) && Character.isDigit(secondSymbol)){
                    length = Integer.parseInt(text2.substring(index + 3,index + 5));
                    index = -1;
                }else{
                    index = text2.indexOf(asciiCode, index + 1);
                }
            }

            // find the word
            char capital = capitalLetter.charAt(i);

            for (int j = 0; j < words.length; j++) {
                if (words[j].charAt(0) == capital && words[j].length() == length + 1){
                    System.out.println(words[j]);
                    break;
                }
            }

        }
    }
}
