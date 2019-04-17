import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonEra {
    public static int dragonsCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int dragonStart = Integer.parseInt(sc.readLine());
        List<Dragon> dragons = new ArrayList<>();

//        for (int i = 1; i <= dragonStart; i++) {
//            Dragon dragon = new Dragon("Dragon_" + i, 0);
//            int eggs = Integer.parseInt(sc.readLine());
//            for (int e = 0; e < eggs; e++) {
//               Egg egg = new Egg(0, dragon);
//                dragon.lay(egg);
//            }
//            dragons.add(dragon);
//        }
        dragonsCount = dragonStart + 1;
        int years = Integer.parseInt(sc.readLine());
        for (int i = 1; i <= years; i++) {
            String yearType = sc.readLine();
            YearType yearFactor = YearType.valueOf(yearType);
        }
    }

    static void passAge(Dragon dragon, YearType yearType) {
        dragon.getAge();
        dragon.lay();
        if (dragon.isAlive) {
            for (Egg egg : dragon.getEggs()) {

            }
        }
    }

    public class Dragon {

        private static final int AGE_DEATH = 6;
        private static final int AGE_LAY_EGGS_START = 3;
        private static final int AGE_LAY_EGGS_END = 4;

        private String name;
        private int age;
        private boolean isAlive = true;
        private List<Egg> eggs;
        private List<Dragon> offspring;

        public List<Egg> getEggs() {
            return eggs;
        }

        public Dragon(String name, int age) {
            this.name = name;
            this.age = age;
            this.eggs = new ArrayList<>();
        }

        public void increaseOffspring(Dragon dragon) {
            offspring.add(dragon);
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setAge(String name) {
            this.name = name;
        }

        public void lay(Egg egg) {
            this.eggs.add(egg);
        }

        public void lay() {
            boolean isMature = this.age >= AGE_LAY_EGGS_START && this.age <= AGE_LAY_EGGS_END;
            if (isMature) {
                Egg egg = new Egg(0, this);
                this.eggs.add(egg);
            }
        }

        public void age() {
            if (this.isAlive) {
                this.age++;
            }
            if (this.age == AGE_DEATH) {
                isAlive = false;
            }
        }
    }

    public class Egg {

        private static final int AGE_HATCH = 2;

        private int age;
        private Dragon parrent;

        public Egg(int age, Dragon parrent) {
            this.age = age;
            this.parrent = parrent;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Dragon getParrent() {
            return parrent;
        }

        public void setParrent(Dragon parrent) {
            this.parrent = parrent;
        }

        public void age() {
            this.age++;
        }

        public void hatch() {
            if (this.age == AGE_HATCH) {
                Dragon baby = new Dragon(this.parrent.getName() + "/" + "Dragon_" + dragonsCount, 0);
                this.parrent.increaseOffspring(baby);
                dragonsCount++;
            }
        }
    }

    enum YearType {
        Bad,
        Normal,
        Good
    }

}
