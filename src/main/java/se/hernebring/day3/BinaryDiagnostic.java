package se.hernebring.day3;

import java.util.Scanner;

public class BinaryDiagnostic {
    private int values = 1;
    private final int[] ones;

    private String current;

    public BinaryDiagnostic(Scanner sc) {
        current = sc.next();
        int bits = current.length();
        ones = new int[bits];
        for(int i = 0; i < bits; i++)
            ones[i] = Character.getNumericValue(current.charAt(i));

        sumDataByBits(sc);
    }

    private void sumDataByBits(Scanner sc) {
        while(sc.hasNext()) {
            values++;
            current = sc.next();
            for(int i = 0; i < ones.length; i++) {
                if (current.charAt(i) == '1')
                    ones[i] += 1;

            }
        }
    }

    public int computeGammaEpsilonMultiplier() {
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for(int one : ones) {
            if(one > values / 2) {
                gamma.append('1');
                epsilon.append('0');
            }
            else {
                gamma.append('0');
                epsilon.append('1');
            }
        }
        return Integer.parseInt(gamma.toString(), 2) *
                Integer.parseInt(epsilon.toString(), 2);
    }

    int getCurrent() {
        return Integer.parseInt(current, 2);
    }

    int getBits() {
        return ones.length;
    }
}
