package app.models.actions;

import app.contracts.Action;
import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.AbstractHero;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

public class BossFight implements Action {

    private List<Targetable> participants;

    @Override
    public String executeAction(List<Targetable> participants) {
        this.participants = participants;
        StringBuilder sb = new StringBuilder();
        String error = "There should be at least 1 participant for boss fight!";

        Deque<Targetable> fighters = new ArrayDeque<>(participants);
        Targetable boss = fighters.pollFirst();
        if(!boss.getClass().getSimpleName().equals("Boss")){
            return "Invalid boss.";
        }

        if (fighters.size() < 1) {
            return error;
        }

        while (boss.isAlive() && fighters.size() > 0) {
            Hero heroInTurn = (Hero) fighters.pollFirst();

            String specialAbility = getSpeciaAability(heroInTurn);
            if (specialAbility != null && heroInTurn.getClass().getSimpleName().equals("Wizard")) {
                triggerAbility(heroInTurn, specialAbility);
            }
            boss.takeDamage(heroInTurn.getDamage());
            boss.attack(heroInTurn);

            if (heroInTurn.getClass().getSimpleName().equals("Warrior") && specialAbility != null){
                triggerAbility(heroInTurn, specialAbility);
            }else if (specialAbility != null && this.getClass().getSimpleName().equals("Necromancer")) {
              triggerAbility(heroInTurn,specialAbility);
            }

            if (heroInTurn.isAlive()) {
                fighters.addLast(heroInTurn);
            }
        }

        if (!boss.isAlive()) {
            sb.append(String.format("%s has been slain by:", boss.getClass().getSimpleName())).append(System.lineSeparator());
            fighters.forEach(Targetable::levelUp);
            fighters.forEach(hero -> hero.receiveReward(Config.BOSS_INDIVIDUAL_REWARD));
            boss.giveReward(fighters.peekLast());
            sb.append(fighters.pollLast()).append(System.lineSeparator());
            fighters.stream()
                    .sorted(Comparator.comparing(Targetable::getName))
                    .forEach(hero -> sb.append(hero).append(System.lineSeparator()));
        } else {
            sb.append(String.format("Boss has slain them all!"));
        }
        return sb.toString().trim();
    }

    private void triggerAbility(Hero heroInTurn, String specialAbility) {
        switch (specialAbility) {
            case "Heal":
                if (heroInTurn.getHealth() <= heroInTurn.getStrength() * Config.HERO_HEALTH_MULTIPLIER * 0.5) {
                    heroInTurn.setHealth(heroInTurn.getHealth() + heroInTurn.getIntelligence());
                }
                break;
            case "Toughness":
                if (heroInTurn.getHealth() <= heroInTurn.getStrength() * Config.HERO_HEALTH_MULTIPLIER * 0.5) {
                    heroInTurn.setStrength(heroInTurn.getStrength() + heroInTurn.getIntelligence());
                }
                break;
            case "Swiftness":
                if (heroInTurn.getHealth() >= heroInTurn.getStrength() * Config.HERO_HEALTH_MULTIPLIER * 0.5) {
                    heroInTurn.setDexterity(heroInTurn.getDexterity() + heroInTurn.getIntelligence());
                }
                break;
        }
    }

    private String getSpeciaAability(Targetable heroInTurn) {
        String specialAb = null;
        Class warriorClass = AbstractHero.class;
        Field field = warriorClass.getDeclaredFields()[9];
        field.setAccessible(true);
        try {
            specialAb = (String) field.get(heroInTurn);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        field.setAccessible(false);
        return specialAb;
    }

}
