package Exams.BattleGround.models.units;


import Exams.BattleGround.constants.GameConstants;
import Exams.BattleGround.interfaces.*;

public class Carrier extends BaseUnit {

    public Carrier(String name, Position position,
                   CombatHandler combatHandler) {
        super(name, GameConstants.CARRIER_RANGE, position,
                GameConstants.CARRIER_HEALTH_POINTS,
                GameConstants.CARRIER_ENERGY_POINTS,
                GameConstants.CARRIER_ATTACK_POINTS,
                GameConstants.CARRIER_DEFENCE_POINTS,
                combatHandler);
    }

}
