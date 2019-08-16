package Exams.BattleGround.factories;


import Exams.BattleGround.handlers.CarrierCombatHandler;
import Exams.BattleGround.handlers.MarineCombatHandler;
import Exams.BattleGround.interfaces.CombatHandler;

final class CombatHandlerFactory {

    private CombatHandlerFactory() {
    }

    static CombatHandler createCarrierCombatHandler() {
        return new CarrierCombatHandler();
    }

    static CombatHandler createMarineCombatHandler() {
        return new MarineCombatHandler();
    }
}
