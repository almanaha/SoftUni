package EXAMS.April2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalBreakpoint {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> allLines = new ArrayList<>();

        String inputLine;
        while (!"Break it.".equalsIgnoreCase(inputLine = sc.readLine())) {
            int[] inputCoordinates = Arrays.stream(inputLine.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[] currentLine = new int[4];

            currentLine[0] = inputCoordinates[0]; //X1
            currentLine[1] = inputCoordinates[1]; //Y1
            currentLine[2] = inputCoordinates[2]; //X2
            currentLine[3] = inputCoordinates[3]; //Y2

            allLines.add(currentLine);
        }

        boolean hasFoundBreakpoint = true;

        Long neededRatio =
                Math.abs(((long) allLines.get(0)[3] +
                        (long) allLines.get(0)[2]) -
                        ((long) allLines.get(0)[1] + (long) allLines.get(0)[0]));

        for (int i = 1; i < allLines.size(); i++) {
            int[] currentLine = allLines.get(i);

            Long currentLineCriticalRatio =
                    Math.abs(((long) currentLine[3] +
                            (long) currentLine[2]) -
                            ((long) currentLine[1] + (long) currentLine[0]));

            if (neededRatio == 0) {
                neededRatio = currentLineCriticalRatio;
            }
            if (!currentLineCriticalRatio.equals(neededRatio) &&
                    !currentLineCriticalRatio.equals(0L)) {
                hasFoundBreakpoint = false;
                break;
            }
        }
        if (hasFoundBreakpoint) {
            for (int i = 0; i < allLines.size(); i++) {
                System.out.println("Line: " + Arrays.toString(allLines.get(i)));
            }

            BigInteger result = new BigInteger(neededRatio.toString());
            result = result.pow(allLines.size());

            BigInteger divisor = new BigInteger(Integer.valueOf(allLines.size()).toString());
            BigInteger criticalBreakpoint = result.remainder(divisor);
            System.out.println(String.format("Critical Breakpoint: %s", criticalBreakpoint));
        } else {
            System.out.println("Critical breakpoint does not exist.");
        }
    }
}

