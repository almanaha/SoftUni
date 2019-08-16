package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss implements Targetable {
    private String name;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;

    public Boss(String name) {
        this.name = name;
        this.health = Config.BOSS_HEALTH;
        this.damage = Config.BOSS_DAMAGE;
        this.gold = Config.BOSS_GOLD;
        this.isAlive = true;
    }

    @Override
    public String attack(Targetable target) {
        String result = "";
        if (!this.isAlive()) {
            return result;
        }
        if (!target.isAlive()) {
            return result;
        }
        target.takeDamage(this.getDamage());

        if (!target.isAlive()) {
            this.levelUp();
           target.giveReward(this);
        }
        return result;
    }


    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.health - damage);
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
    public double getHealth() {

        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
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
    public void receiveReward(double reward) {
        this.gold += reward*0.9;
    }

    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public boolean isAlive() {
        if (this.getHealth() <= 0) {
            this.isAlive = false;
        }
        return this.isAlive;
    }
}
