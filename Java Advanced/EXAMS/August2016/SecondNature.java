package EXAMS.August2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = reader.readLine().split("[\\s]+");
        String[] line2 = reader.readLine().split("[\\s]+");

        ArrayList<Integer> flowers = parseLine(line1);
        ArrayList<Integer> buckets = parseLine(line2);
        ArrayList<Integer> secondNature = new ArrayList<>();

        for (int i = 0; i < flowers.size(); i++) {
            for (int j = buckets.size() - 1; j >= 0; j--) {
                if (i < flowers.size()) {
                    int restOfTheBucket = buckets.get(j) - flowers.get(i);

                    if (restOfTheBucket == 0) {
                        secondNature.add(flowers.get(i));
                        flowers.set(i, 0);
                        i++;
                        buckets.set(j, 0);
                    }
                    if (restOfTheBucket > 0 && j > 0) {
                        buckets.set(j - 1, buckets.get(j - 1) + restOfTheBucket);
                        flowers.set(i, 0);
                        i++;
                        buckets.set(j, 0);
                    } else if (restOfTheBucket > 0 && j == 0 && i < flowers.size()) {
                        buckets.set(j, buckets.get(j) - flowers.get(i));
                        flowers.set(i, 0);
                        i++;
                        j++;
                    }
                    if (restOfTheBucket < 0) {
                        flowers.set(i, flowers.get(i) - buckets.get(j));
                        buckets.set(j, 0);
                    }
                }
            }
        }

        flowers = listClear(flowers);
        buckets = listClear(buckets);

        if (flowers.size() < 1) {
            //System.out.print("Bucks ");
            for (int i = buckets.size() - 1; i >= 0; i--) {
                System.out.print(buckets.get(i) + " ");
            }
            System.out.println();
        } else {
            //System.out.print("Flows ");
            for (Integer flower : flowers) {
                System.out.print(flower + " ");
            }
            System.out.println();
        }

        if (secondNature.size() > 0) {
            //System.out.print("SecNat ");
            for (Integer integer : secondNature) {
                System.out.print(integer + " ");
            }
            System.out.println();
        } else {
            System.out.println("None");
        }

    }

    private static ArrayList<Integer> listClear(ArrayList<Integer> items) {
        items.removeAll(Collections.singleton(0));
        return items;
    }

    private static ArrayList<Integer> parseLine(String[] line) {
        ArrayList<Integer> parsedNumbs = new ArrayList<>();
        for (String s : line) {
            parsedNumbs.add(Integer.valueOf(s));
        }
        return parsedNumbs;
    }
}
