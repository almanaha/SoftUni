package EXAMS.June2019Sample.healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        for (Salad salad : data) {
            if (salad.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Salad getHealthiestSalad() {
        return this.data.stream().min(Comparator.comparing(Salad::getTotalCalories)).get();
    }

    public String generateMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s have %s salads:", this.name, this.data.size()))
                .append(System.lineSeparator());
        data.forEach(e -> sb.append(e).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
