package Exams.BattleGround.factories;


import Exams.BattleGround.enums.UnitType;
import Exams.BattleGround.interfaces.Position;
import Exams.BattleGround.interfaces.Unit;
import Exams.BattleGround.models.PositionImpl;
import Exams.BattleGround.models.units.Carrier;
import Exams.BattleGround.models.units.Marine;

public final class UnitFactory {

    private UnitFactory() {
    }

    public static Unit createUnit(UnitType unitType, String name, int xPosition, int yPosition) {
        Position position;
        switch (unitType) {
            case MARINE:
                position = new PositionImpl(xPosition, yPosition);
                return new Marine(name,
                        position,
                        CombatHandlerFactory.createMarineCombatHandler());
            case CARRIER:
                position = new PositionImpl(xPosition, yPosition);
                return new Carrier(name,
                        position,
                        CombatHandlerFactory.createCarrierCombatHandler());
            default:
                return null;
        }
    }
}
