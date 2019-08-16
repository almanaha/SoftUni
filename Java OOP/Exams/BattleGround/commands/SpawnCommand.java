package Exams.BattleGround.commands;


import Exams.BattleGround.constants.ExceptionMessagesConstants;
import Exams.BattleGround.enums.UnitType;
import Exams.BattleGround.exceptions.*;
import Exams.BattleGround.factories.UnitFactory;
import Exams.BattleGround.interfaces.*;

public class SpawnCommand implements Command {
    private Battleground battleground;
    private Repository<Unit> unitRepository;

    public SpawnCommand(Battleground battleground, Repository<Unit> unitRepository) {
        this.battleground = battleground;
        this.unitRepository = unitRepository;
    }

    @Override
    public String execute(String[] args) throws InvalidUnitTypeException, InvalidPositionException {
        String typeUnit = args[1];
        UnitType unitType;
        try {
            unitType = UnitType.valueOf(typeUnit.toUpperCase());
        } catch (IllegalArgumentException iae) {
            throw new InvalidUnitTypeException(ExceptionMessagesConstants.INVALID_UNIT_TYPE_EXCEPTION_MESSAGE);
        }

        String unitName = args[2];
        int xPosition = Integer.parseInt(args[3]);
        int yPosition = Integer.parseInt(args[4]);
        Unit unit = UnitFactory.createUnit(unitType, unitName, xPosition, yPosition);

        this.battleground.add(unit);
        this.unitRepository.save(unit);

        return String.format("%s of type %s has spawn @(%d, %d)", unitName, unitType.toString(), xPosition, yPosition);
    }
}
