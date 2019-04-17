package Exams.November2017;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class AnonymousDownsite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer count = Integer.parseInt(sc.nextLine());
        Integer key = Integer.parseInt(sc.nextLine());
        String[] inputTokens = sc.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        BigDecimal sum = BigDecimal.valueOf(0d);
        for (int i = 0; i < count; i++) {
            if (Character.isLetter(inputTokens[0].charAt(0)) && Character.isDigit(inputTokens[1].charAt(0))) {
                String name = inputTokens[0];
                long siteVisits = Long.parseLong(inputTokens[1]);
                double commercialPrice = Double.parseDouble(inputTokens[2]);
                sb.append(name);
                if(i < count - 1){
                    sb.append("\n");
                }
                sum = sum.add((BigDecimal.valueOf(commercialPrice)).multiply(BigDecimal.valueOf(siteVisits)));
            }
            inputTokens = sc.nextLine().split(" ");
        }
        System.out.println(sb.toString());
        System.out.printf("Total Loss: %.20f\n", sum);
        BigInteger keyPowered = new BigInteger(String.valueOf(key));
        keyPowered = keyPowered.pow(count);
        System.out.printf("Security Token: %d", keyPowered);
    }
}
