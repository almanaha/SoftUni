package Exams.BattleGround.io;


import Exams.BattleGround.interfaces.*;

import java.io.*;

public class ConsoleReader implements InputReader {

    private BufferedReader reader;

    public ConsoleReader(){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
