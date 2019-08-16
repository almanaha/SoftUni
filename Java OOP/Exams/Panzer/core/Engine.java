package panzer.core;

import panzer.constants.Config;
import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Manager manager;

    public Engine(InputReader inputReader, OutputWriter outputWriter, Manager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.manager = manager;
    }

    public void run() {

        while (true) {
            String inputLine = inputReader.readLine();
            List<String> tokens = Arrays.stream(inputLine.split("\\s+")).collect(Collectors.toList());
            commandDispatcher(tokens);

            if (Config.TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }
        }
    }

    private void commandDispatcher(List<String> arguments) {

        String command = arguments.get(0);
        switch (command) {
            case Config.VEHICLE_COMMAND:
                this.outputWriter.println(this.manager.addVehicle(arguments));
                break;
            case Config.PART_COMMAND:
               this.outputWriter.println(this.manager.addPart(arguments));
                break;
            case Config.INSPECT_COMMAND:
                this.outputWriter.println(this.manager.inspect(arguments));
                break;
            case Config.BATTLE_COMMAND:
                this.outputWriter.println(this.manager.battle(arguments));
                break;
            case Config.TERMINATE_COMMAND:
               this.outputWriter.print(this.manager.terminate(arguments));
                break;
        }

    }
}
