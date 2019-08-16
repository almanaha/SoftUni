package Exams.BattleGround.interfaces;


import Exams.BattleGround.exceptions.*;

public interface Command {

    String execute(String[] args) throws InvalidUnitTypeException, InvalidPositionException, UnitNotExistException, NotEnoughEnergyException;
}
