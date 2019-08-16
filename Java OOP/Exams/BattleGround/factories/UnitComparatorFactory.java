package Exams.BattleGround.factories;


import Exams.BattleGround.comparators.*;
import Exams.BattleGround.interfaces.*;

import java.util.*;

public final class UnitComparatorFactory {

    private UnitComparatorFactory() {
    }

    public static Comparator<Unit> createComparatorByHealthPoints() {
        return new UnitComparatorByHealthPoints();
    }

    public static Comparator<Unit> createComparatorByName() {
        return new UnitComparatorByName();
    }
}
