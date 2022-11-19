package se.hernebring.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Crab {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/day7.txt");
        Scanner sc = new Scanner(file);
        int[] input = Arrays.stream(sc.next().split(",")).mapToInt(Integer::parseInt).toArray();
        sc.close();
        System.out.println(calc(input));
    }

    public static int calc(int[] crabs) {
        Map<Integer,Integer> position  = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i : crabs) {
            if(position.containsKey(i))
                position.put(i, position.get(i) + 1);
            else {
                position.put(i, 1);
                if(i < min)
                    min = i;

                if(i > max)
                    max = i;

            }
        }
        int minDiff = Integer.MAX_VALUE;
        for(int i = min; i <= max; i++) {
            int total = 0;
            for(var entry : position.entrySet())
                total += entry.getValue() * (Math.abs(entry.getKey() - i));

            if(total < minDiff)
                minDiff = total;

        }
        return minDiff;
    }
}
