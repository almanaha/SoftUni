package StacksAndQueues;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        ArrayDeque<String> calc = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(calc::offer);
//        Collections.addAll(calc,nums);

        while (calc.size() > 1){

            Integer x = Integer.parseInt(calc.pop());
            String operator = calc.pop();
            int y = Integer.parseInt(calc.pop());

            if (operator.equals("+")){
                calc.push(String.valueOf(x + y));
            }else{
                calc.push(String.valueOf(x - y));
            }
        }
        System.out.println(calc.peek());
    }
}
