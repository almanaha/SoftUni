package ObjectsАndClasses;
import java.util.*;
public class RollTheDice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int diceCount = Integer.parseInt(sc.nextLine());
        int diceSides = Integer.parseInt(sc.nextLine());
        int winningSumMin = Integer.parseInt(sc.nextLine());

        List<Dice> dices = new ArrayList<>();

        for (int i = 0; i < diceCount; i++) {
            Dice dice = new Dice(diceSides);
            dices.add(dice);
        }
        int sum = 0;
        for (Dice dice : dices) {
            sum += dice.roll();
        }
        System.out.println("Your sum is: " + sum);
        if (sum >= winningSumMin)
            System.out.println("Congratulations, you have won the Big nOthing");
        else
            System.out.println("Sorry, you have lost. Try again the national lotary.");

    }

    static class Dice{
        int sides;
        public Dice(int sides) throws IllegalArgumentException {
            if (sides <= 0 || sides % 2 != 0){
                throw new IllegalArgumentException("The dice must have at least HelloFrance side and must be even");
            }
            this.sides = sides;
        }
        int roll(){
            return new Random().nextInt(this.sides + 1);
        }
    }
}
