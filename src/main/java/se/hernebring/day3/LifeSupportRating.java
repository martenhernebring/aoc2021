package se.hernebring.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LifeSupportRating {

    private final List<String> values = new ArrayList<>();
    private final int bits;

    public LifeSupportRating(Scanner scanner) {
        String current = scanner.next();
        bits = current.length();
        values.add(current);
        while(scanner.hasNext())
            values.add(scanner.next());

    }

    public int computeOxygenCO2Multiplier() {
        List<String> oxygen = computeOxygen();
        computeCo2();
        return Integer.parseInt(oxygen.get(0), 2) *
                Integer.parseInt(values.get(0), 2);
    }

    private List<String> computeOxygen() {
        List<String> oxygen = new ArrayList<>(values);
        for(int i = 0; oxygen.size() > 1 & i < bits; i++) {
            int ones = 0;
            for(String o : oxygen) {
                if(o.charAt(i) == '1')
                    ones++;

            }
            if(ones != oxygen.size()) {
                final int fi = i;
                if(ones >= (double) oxygen.size() / 2)
                    oxygen.removeIf(s -> s.charAt(fi) == '0');
                else
                    oxygen.removeIf(s -> s.charAt(fi) == '1');
            }
        }
        return oxygen;
    }

    private void computeCo2() {
        for(int i = 0; values.size() > 1 & i < bits; i++) {
            int ones = 0;
            for(String v : values) {
                if(v.charAt(i) == '1')
                    ones++;

            }
            if(ones != values.size()) {
                final int fi = i;
                if(ones >= (double) values.size() / 2)
                    values.removeIf(s -> s.charAt(fi) == '1');
                else
                    values.removeIf(s -> s.charAt(fi) == '0');
            }
        }
    }
}
