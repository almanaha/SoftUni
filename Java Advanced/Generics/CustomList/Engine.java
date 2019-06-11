package Generics.CustomList;
import java.util.*;

public class Engine implements Runnable{
    private static final String END_COMMAND = "END";
    private Scanner sc;
    private String input;
    private CommandParser commandParser;

    public Engine() {
        this.sc = new Scanner(System.in);
        this.input = "";
        this.commandParser = new CommandParser();
    }

    @Override
    public void run() {
        this.input = this.sc.nextLine();

        while (!this.input.equals(END_COMMAND)){

        this.commandParser.execute(this.input);


            this.input = this.sc.nextLine();
        }
    }
}
