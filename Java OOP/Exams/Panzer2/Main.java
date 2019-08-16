package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.core.BusinessManager;
import panzer.core.ConsoleReader;
import panzer.core.ConsoleWriter;
import panzer.core.Engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        InputReader reader = new ConsoleReader(buf);
        OutputWriter writer = new ConsoleWriter();
        Manager manager = new BusinessManager();

        Engine engine = new Engine(reader, writer, manager);
        engine.run();
    }
}
