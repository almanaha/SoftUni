package Exams.BattleGround.models.units;


import Exams.BattleGround.constants.GameConstants;
import Exams.BattleGround.interfaces.CombatHandler;
import Exams.BattleGround.interfaces.Position;

public class Marine extends BaseUnit {


    public Marine(String name, Position position, CombatHandler combatHandler) {
        super(name, GameConstants.MARINE_RANGE, position,
                GameConstants.MARINE_HEALTH_POINTS, GameConstants.MARINE_ENERGY_POINTS,
                GameConstants.MARINE_ATTACK_POINTS,
                GameConstants.MARINE_DEFENCE_POINTS, combatHandler);
    }
}
