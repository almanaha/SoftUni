package Exams.BattleGround;


import Exams.BattleGround.core.GameEngine;
import Exams.BattleGround.dispachers.CommandDispatcher;
import Exams.BattleGround.interfaces.*;
import Exams.BattleGround.io.*;
import Exams.BattleGround.models.*;
import Exams.BattleGround.repository.*;

import java.io.*;

public class Main {
    private static final int ROWS = 5;
    private static final int COLS = 5;

    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Battleground battleground = new BattlegroundImpl(ROWS, COLS);
        Repository<Unit> unitRepository = new UnitRepository();
        CommandDispatcher commandDispatcher = new CommandDispatcher(battleground, unitRepository);
        Engine gameGameEngine = new GameEngine(reader, writer, commandDispatcher);

        gameGameEngine.start();
    }
}
