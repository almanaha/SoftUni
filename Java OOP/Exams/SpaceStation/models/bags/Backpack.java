package Q_Exams.RetakeExam15August2019.spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Backpack implements Bag {
    private Collection<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String toString() {
        String result = "Bag items: ";
        if (items.size() > 0){
            result += items.stream().collect(Collectors.joining(", "));
        } else {
            result += "none";
        }
        return result;
    }
}
