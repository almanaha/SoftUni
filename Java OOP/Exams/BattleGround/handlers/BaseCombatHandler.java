package Exams.BattleGround.handlers;


import Exams.BattleGround.factories.UnitComparatorFactory;
import Exams.BattleGround.interfaces.CombatHandler;
import Exams.BattleGround.interfaces.Unit;

import java.util.*;

public abstract class BaseCombatHandler implements CombatHandler {
    private final int CLOSEST_ENEMY = 0;

    private Unit unit;

    protected BaseCombatHandler() {
    }

    protected Unit getUnit() {
        return this.unit;
    }

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public Unit pickNextTarget(List<Unit> targetCandidates) {
        targetCandidates.sort(
                UnitComparatorFactory.createComparatorByHealthPoints()
                        .thenComparing(
                                UnitComparatorFactory.createComparatorByName()));
        return targetCandidates.get(CLOSEST_ENEMY);
    }
}
