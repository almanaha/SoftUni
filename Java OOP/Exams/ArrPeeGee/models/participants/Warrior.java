package app.models.participants;

import app.models.Config;

public class Warrior extends AbstractHero {

   public Warrior(String name) {
        super(name);
        super.setStrength(Config.WARRIOR_BASE_STRENGTH);
        super.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
        super.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
        super.setHealth(super.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        super.setDamage(super.getStrength() * 2 + super.getDexterity());
    }
}
