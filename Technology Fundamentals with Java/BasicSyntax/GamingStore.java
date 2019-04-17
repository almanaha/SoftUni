package BasicSyntax;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = Double.parseDouble(sc.nextLine());
        double sum = 0;
        double gamePrice = 0;
        String game = sc.nextLine();
        while(true){
            if (game.equals("Game Time")){
                System.out.printf("Total spent: $%.2f. Remaining: $%.2f",sum,money);
                break;
            }
            switch (game){
                case "OutFall 4": gamePrice = 39.99; break;
                case "CS: OG": gamePrice = 15.99; break;
                case "Zplinter Zell": gamePrice = 19.99; break;
                case "Honored 2": gamePrice = 59.99; break;
                case "RoverWatch": gamePrice = 29.99; break;
                case "RoverWatch Origins Edition": gamePrice = 39.99; break;
                default: System.out.println("Not Found");break;
            }

            if (money >= gamePrice && gamePrice > 0){
                System.out.println("Bought " + game);
                sum += gamePrice;
                money -= gamePrice;
            }else if (gamePrice >= money && !game.equals("Not Found")){
                System.out.println("Too Expensive");
            }

            if (money <= 0){
                System.out.println("Out of money!");
                break;
            }
            game = sc.nextLine();

        }
    }
}
