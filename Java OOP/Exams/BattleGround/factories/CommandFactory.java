package Exams.BattleGround.factories;


import Exams.BattleGround.commands.*;
import Exams.BattleGround.interfaces.*;

public final class CommandFactory {

    private CommandFactory() {}

    public static Command createSpawnCommand(Battleground battleground, Repository<Unit> unitRepository) {
        return new SpawnCommand(battleground, unitRepository);
    }

    public static Command createMoveCommand(Battleground battleground, Repository<Unit> unitRepository) {
        return new MoveCommand(battleground, unitRepository);
    }

    public static Command createStatusCommand(Repository<Unit> unitRepository) {
        return new StatusCommand(unitRepository);
    }

    public static Command createFightCommand(Battleground battleground, Repository<Unit> unitRepository) {
        return new FightCommand(battleground, unitRepository);
    }

    public static Command createGameOverCommand() {
        return new GameOverCommand();
    }
}
