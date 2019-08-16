package panzer.core;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {

    private InputReader reader;

    private OutputWriter writer;

    private Manager manager;

    public Engine(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    public void run() throws ClassNotFoundException {
        String input;
        while (true) {
            input = reader.readLine();
            String[] tokens = input.trim().split("\\s+");
            String cmd = tokens[0];
            List<String> arguments = Arrays.stream(tokens).skip(1).collect(Collectors.toList());
            switch (cmd) {
                case "Vehicle":
                    writer.println(manager.addVehicle(arguments));
                    break;
                case "Part":
                    writer.println(manager.addPart(arguments));
                    break;
                case "Inspect":
                    writer.println(manager.inspect(arguments));
                    break;
                case "Battle":
                    writer.println(manager.battle(arguments));
                    break;
                case "Terminate":
                    writer.println(manager.terminate(arguments));
                    return;
            }
        }
    }
}
