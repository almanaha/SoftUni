package Exams.BattleGround.interfaces;


import Exams.BattleGround.exceptions.NotEnoughEnergyException;

import java.util.List;

public interface CombatHandler {

    void setUnit(Unit unit);

    Unit pickNextTarget(List<Unit> targetCandidates);

    Spell generateAttack() throws NotEnoughEnergyException;
}
