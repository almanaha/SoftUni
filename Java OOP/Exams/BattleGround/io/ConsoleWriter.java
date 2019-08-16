package Exams.BattleGround.io;


import Exams.BattleGround.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
