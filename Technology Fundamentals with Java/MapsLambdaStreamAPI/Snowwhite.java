package MapsLambdaStreamAPI;
import java.util.*;

public class Snowwhite {

    static class Dwarf {
        private String name;
        private String color;
        private int physics;

        public Dwarf(String name, String color, int physics) {
            this.name = name;
            this.color = color;
            this.physics = physics;
        }

        public void setPhysics(int physics) {
            this.physics = Math.max(physics, this.getPhysics());
        }

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        public int getPhysics() {
            return physics;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Dwarf> dwarves = new ArrayList<>();
        Map<String, Integer> countsByColor = new HashMap<>();

        String line;
        while (!"Once upon a time".equals(line = sc.nextLine())) {
            String[] tokens = line.split(" <:> ");
            String name = tokens[0];
            String color = tokens[1];
            int physics = Integer.parseInt(tokens[2]);

            Optional<Dwarf> dwarfCandidate = dwarves.stream()
                    .filter(dwarf -> dwarf.getName().equals(name) &&
                            dwarf.getColor().equals(color))
                    .findFirst();

            if (dwarfCandidate.isPresent()) {
                Dwarf dwarf = dwarfCandidate.get();
                dwarf.setPhysics(physics);
            } else {
                Dwarf dwarf = new Dwarf(name, color, physics);
                countsByColor.putIfAbsent(color, 0);
                countsByColor.put(color, countsByColor.get(color) + 1);
                dwarves.add(dwarf);
            }
        }

        dwarves.sort((d1, d2) -> {
            if (d1.getPhysics() == d2.getPhysics()) {
                return countsByColor.get(d2.getColor()).compareTo(countsByColor.get(d1.getColor()));
            }
            return Integer.compare(d2.getPhysics(), d1.getPhysics()); // reverse order
        });

        dwarves.forEach(dwarf -> System.out.printf("(%s) %s <-> %d%n",
                dwarf.getColor(),
                dwarf.getName(),
                dwarf.getPhysics()));
    }
}