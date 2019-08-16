package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

import java.lang.reflect.Field;

public abstract class AbstractHero implements Hero {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;
    private String specialAbility;

    AbstractHero(String name) {
        this.name = name;
        this.level = 1;
        this.gold = Config.HERO_START_GOLD;
        this.isAlive = true;
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()) {
            return target.getName() + " is dead! Cannot be attacked.";
        }
        if (this.specialAbility != null && this.getClass().getSimpleName().equals("Wizard")) {
            triggerSpecialAbility();
        }

        target.takeDamage(this.getDamage());

        String specialAb = null;
        Class warriorClass = AbstractHero.class;
        Field field = warriorClass.getDeclaredFields()[9];
        field.setAccessible(true);
        try {
            specialAb = (String) field.get(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        field.setAccessible(false);
        if (target.getClass().getSimpleName().equals("Warrior") && specialAb != null){
            triggerWarrior(specialAb);
        }
        if (this.specialAbility != null && this.getClass().getSimpleName().equals("Necromancer")) {
            triggerSpecialAbility();
        }
        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

    private void triggerWarrior(String specialAb) {
        switch (specialAb) {
            case "Heal":
                if (this.getHealth() <= this.getStrength() * Config.HERO_HEALTH_MULTIPLIER * 0.5) {
                    this.setHealth(this.getHealth() + this.getIntelligence());
                }
                break;
            case "Toughness":
                if (this.getHealth() <= this.getStrength() * Config.HERO_HEALTH_MULTIPLIER * 0.5) {
                    this.setStrength(this.getStrength() + this.getIntelligence());
                }
                break;
            case "Swiftness":
                if (this.getHealth() >= this.getStrength() * Config.HERO_HEALTH_MULTIPLIER * 0.5) {
                    this.setDexterity(this.getDexterity() + this.getIntelligence());
                }
                break;
        }
    }

    private void triggerSpecialAbility() {
        triggerWarrior(specialAbility);
    }

    @Override
    public void receiveReward(double reward) {
        this.gold += reward;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.health - damage);
    }

    @Override
    public int getStrength() {

        return this.strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
        // this.setHealth(strength * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {

        this.intelligence = intelligence;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public boolean isAlive() {
        if (this.getHealth() <= 0) {
            this.isAlive = false;
        }
        return this.isAlive;
    }

    @Override
    public void levelUp() {
        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
        this.setDamage(this.getDamage() * Config.LEVEL_UP_MULTIPLIER);
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.level += 1;
    }

    protected String getSpecialAbility() {
        return specialAbility;
    }

    protected void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold",
                        this.getStrength(), this.getDexterity(), this.getIntelligence(), this.gold));

        return sb.toString();
    }
}
