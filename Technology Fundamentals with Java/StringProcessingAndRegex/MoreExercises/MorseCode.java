package StringProcessingAndRegex.MoreExercises;

import java.util.*;

public class MorseCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] data = sc.nextLine().split("\\|");
        StringBuilder code = new StringBuilder();

        for (String morse : data) {
            String[] morse2 = morse.split(" ");
            for (String c : morse2) {
                switch (c){
                    case ".-": code.append("A"); break;
                    case "-...": code.append("B"); break;
                    case "-.-.": code.append("C"); break;
                    case "-..": code.append("D"); break;
                    case ".": code.append("E"); break;
                    case "..-.": code.append("F"); break;
                    case "--.": code.append("G"); break;
                    case "....": code.append("H"); break;
                    case "..": code.append("I"); break;
                    case ".---": code.append("J"); break;
                    case "-.-": code.append("K"); break;
                    case ".-..": code.append("L"); break;
                    case "--": code.append("M"); break;
                    case "-.": code.append("N"); break;
                    case "---": code.append("O"); break;
                    case ".--.": code.append("P"); break;
                    case "--.-": code.append("Q"); break;
                    case ".-.": code.append("R"); break;
                    case "...": code.append("S"); break;
                    case "-": code.append("T"); break;
                    case "..-": code.append("U"); break;
                    case "...-": code.append("V"); break;
                    case ".--": code.append("W"); break;
                    case "-..-": code.append("X"); break;
                    case "-.--": code.append("Y"); break;
                    case "--..": code.append("Z"); break;
                }
            }
            code.append(" ");
        }
        System.out.println(code);
    }
}
