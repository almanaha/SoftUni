package Exams.BattleGround.commands;


import Exams.BattleGround.interfaces.Command;

import static Exams.BattleGround.constants.GameConstants.*;

public class GameOverCommand implements Command {

    @Override
    public String execute(String[] args) {
        return TERMINATE_OUTPUT;
    }
}
