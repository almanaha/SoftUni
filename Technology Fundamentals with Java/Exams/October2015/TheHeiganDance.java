package Exams.October2015;

import java.util.*;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double heiganHealth = 3000000;
        int playerHealth = 18500;

        double playerDamage = Double.parseDouble(sc.nextLine());
        int playerRow = 7;
        int playerCol = 7;
        String lastSpell = "";

        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(" ");

            if (lastSpell.equals("Cloud")) {
                heiganHealth -= playerDamage;
                playerHealth -= 3500;
            }
            if (heiganHealth <= 0 || playerHealth <= 0) {
                break;
            }
            if (!lastSpell.equals("Cloud")) {
                heiganHealth -= playerDamage;

                if (heiganHealth <= 0) {
                    break;
                }
            }

            lastSpell = "Eruption";
            String spellName = data[0];
            int damageRow = Integer.parseInt(data[1]);
            int damageCol = Integer.parseInt(data[2]);

            int movedOnRow = playerRow;
            int movedOnCol = playerCol;
            if (isInDamageArea(damageRow, damageCol, movedOnRow, movedOnCol)) {
                //going up
                movedOnRow = playerRow - 1;
                if (isInDamageArea(damageRow, damageCol, movedOnRow, movedOnCol) ||
                        isNextWall(movedOnRow, movedOnCol)) {
                    //going right
                    movedOnRow = playerRow;
                    movedOnCol = playerCol + 1;
                    if (isInDamageArea(damageRow, damageCol, movedOnRow, movedOnCol) ||
                            isNextWall(movedOnRow, movedOnCol)) {
                        //going down
                        movedOnRow = playerRow + 1;
                        movedOnCol = playerCol;
                        if (isInDamageArea(damageRow, damageCol, movedOnRow, movedOnCol) ||
                                isNextWall(movedOnRow, movedOnCol)) {
                            //going left
                            movedOnRow = playerRow;
                            movedOnCol = playerCol - 1;
                            if (isInDamageArea(damageRow, damageCol, movedOnRow, movedOnCol) ||
                                    isNextWall(movedOnRow, movedOnCol)) {
                                //we can`t escape the attack
                                if (spellName.equals("Cloud")) {
                                    playerHealth -= 3500;
                                } else {
                                    playerHealth -= 6000;
                                }
                                lastSpell = spellName;
                            } else {
                                //go left
                                playerCol--;
                            }
                        } else {
                            // go down
                            playerRow++;
                        }
                    } else {
                        //go right
                        playerCol++;
                    }
                } else {
                    //go up
                    playerRow--;
                }
            }
        }

        if (heiganHealth <= 0){
            System.out.println("Heigan: Defeated!");
        }else{
            System.out.printf("Heigan: %.2f\n",heiganHealth);
        }
        if (playerHealth <= 0){
            String spell = lastSpell.equals("Cloud") ? "Plague Cloud" : lastSpell;
            System.out.println("Player: Killed by " + spell);
        }else {
            System.out.println("Player: " + playerHealth);
        }

        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }

    private static boolean isNextWall(int movedOnRow, int movedOnCol) {
        return movedOnRow < 0 || movedOnRow >= 15 ||
                movedOnCol < 0 || movedOnCol >= 15;
    }
    private static boolean isInDamageArea(int damageRow, int damageCol, int playerRow, int playerCol) {
        for (int row = damageRow - 1; row <= damageRow + 1; row++) {
            for (int col = damageCol - 1; col <= damageCol + 1; col++) {
                if (playerRow == row && playerCol == col) {
                    return true;
                }
            }
        }
        return false;
    }
}

