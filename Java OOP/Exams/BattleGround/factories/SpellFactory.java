package Exams.BattleGround.factories;


import Exams.BattleGround.enums.*;
import Exams.BattleGround.interfaces.*;
import Exams.BattleGround.models.spells.BulletRain;
import Exams.BattleGround.models.spells.RageShoot;

public final class SpellFactory {

    private SpellFactory() {
    }

    public static Spell createSpell(SpellType type, int damage) {
        switch (type) {
            case RAGE_SHOOT:
                return new RageShoot(damage);
            case BULLET_RAIN:
                return new BulletRain(damage);
            default:
                return null;
        }
    }
}
