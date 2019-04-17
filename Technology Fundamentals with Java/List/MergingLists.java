package List;

import java.util.*;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> arr = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> arr2 = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        int length = Math.min(arr.size(),arr2.size());

        for (int i = 0; i < length; i++) {
            result.add(arr.get(i));
            result.add(arr2.get(i));
        }

        if (arr.size() > arr2.size()) {
            for (int i = arr2.size(); i < arr.size(); i++) {
                result.add(arr.get(i));
            }
        }else if (arr2.size() > arr.size()){
            for (int i = arr.size(); i < arr2.size(); i++) {
                result.add(arr2.get(i));
            }
        }

        for (Integer x : result) {
            System.out.print(x + " ");
        }

    }
}
