package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.core.Engine;
import panzer.core.ManagerImpl;
import panzer.io.ConsoleInputReader;
import panzer.io.ConsoleOutputWriter;

public class Main {
    public static void main(String[] args) {

        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();
        Manager manager = new ManagerImpl();
        Engine engine = new Engine(inputReader, outputWriter, manager);
        engine.run();
    }
}
