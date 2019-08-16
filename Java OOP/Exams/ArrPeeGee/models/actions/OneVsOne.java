package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;

public class OneVsOne implements Action {
    private final static String ERROR_MESSAGE = "There should be exactly 2 participants for OneVsOne!";
    private List<Targetable> participants;

    @Override
    public String executeAction(List<Targetable> participants) {
        if (participants.size() < 2) {
            return ERROR_MESSAGE;
        }
        this.participants = participants;
        StringBuilder sb = new StringBuilder();

        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        while (firstHero.isAlive()) {
            sb.append(firstHero.attack(secondHero)).append(System.lineSeparator());
            if (secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero)).append(System.lineSeparator());
            } else {
                break;
            }
        }

        if (!secondHero.isAlive()) {
            sb.append(String.format("%s is victorious!%s%s",
                    firstHero.getName(), System.lineSeparator(), firstHero.toString()));
        } else {
            sb.append(String.format("%s is victorious!%s%s",
                    secondHero.getName(), System.lineSeparator(), secondHero.toString()));
        }

        return sb.toString();
    }
}
