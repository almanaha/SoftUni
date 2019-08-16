package Exams.BattleGround.commands;


import Exams.BattleGround.exceptions.*;
import Exams.BattleGround.interfaces.*;

import static Exams.BattleGround.constants.ExceptionMessagesConstants.NOT_EXISTING_UNIT_EXCEPTION_MESSAGE;

public class StatusCommand implements Command {
    private Repository<Unit> unitRepository;

    public StatusCommand(Repository<Unit> unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public String execute(String[] args) throws UnitNotExistException {
        String unitName = args[1];

        Unit unit = this.unitRepository.findByName(unitName);

        if (unit == null) {
            throw new UnitNotExistException(String.format(NOT_EXISTING_UNIT_EXCEPTION_MESSAGE, unitName));
        }

        if (unit.getHealthPoints() <= 0) {
            return String.format("Unit with name %s is already dead :((((.", unit.getName());
        }

        return unit.toString();
    }
}
