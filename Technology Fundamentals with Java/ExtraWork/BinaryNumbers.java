package ExtraWork;

import java.util.*;

public class BinaryNumbers {
    public static void main(String[] args) {
        /*Given a base-10 integer n, convert it to binary (base-2).
        Then find and print the base-2 integer denoting the maximum number of
         consecutive 1's in n's binary representation.*/

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] ones = Integer.toBinaryString(n).split("[0]+");
        int max = 0;
        for (String s : ones) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        System.out.println(max);
//The binary representation of 5 is 101
// so the maximum number of consecutive 1's is 1.

//        int counter = 0, max =0;
//        while (n > 0) {
//            int rem = n%2;
//            if (rem==1) counter++;
//            else counter=0;
//            max = Math.max(counter, max);
//            n/=2;
//        }
    }
}
