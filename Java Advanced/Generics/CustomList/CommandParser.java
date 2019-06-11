package Generics.CustomList;

public class CommandParser {
    private SmartList<String> smartList;

    public CommandParser() {
        this.smartList = new SmartList<>();
    }

    public void execute(String command) {
        String[] data = command.split("\\s+");

        switch (data[0]) {
            case "Add":
                this.smartList.add(data[1]);
                break;
            case "Remove":
                this.smartList.remove(Integer.parseInt(data[1]));
                break;
            case "Contains":
                System.out.println(this.smartList.contains(data[1]));
                break;
            case "Swap":
                this.smartList.swap(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                break;
            case "Greater":
                System.out.println(this.smartList.greaterThan(data[1]));
                break;
            case "Max":
                System.out.println(this.smartList.getMax());
                break;
            case "Min":
                System.out.println(this.smartList.getMin());
                break;
            case "Print":
                for (String str : smartList) {
                    System.out.println(str);
                }
                break;
            case "Sort":
                Sorter.sort(smartList);
                break;
        }
    }
}
