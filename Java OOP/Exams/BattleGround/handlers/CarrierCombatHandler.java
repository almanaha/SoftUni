package Exams.BattleGround.handlers;


import Exams.BattleGround.constants.ExceptionMessagesConstants;
import Exams.BattleGround.enums.SpellType;
import Exams.BattleGround.exceptions.NotEnoughEnergyException;
import Exams.BattleGround.factories.SpellFactory;
import Exams.BattleGround.interfaces.Spell;
import Exams.BattleGround.interfaces.Unit;

public class CarrierCombatHandler extends BaseCombatHandler {
    private int spellCount;

    @Override
    public Spell generateAttack() throws NotEnoughEnergyException {
        Unit unit = super.getUnit();
        Spell spell = SpellFactory.createSpell(SpellType.BULLET_RAIN, unit.getAttackPoints());

        this.spellCount++;

        if (this.spellCount % 3 == 0) {
            return spell;
        } else {
            if (unit.getEnergyPoints() <= spell.getEnergyCost()) {
                throw new NotEnoughEnergyException(ExceptionMessagesConstants.NOT_ENOUGH_ENERGY_EXCEPTION_MESSAGE);
            }
        }

        unit.setEnergyPoints(unit.getEnergyPoints() - spell.getEnergyCost());

        return spell;
    }
}
