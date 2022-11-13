package se.hernebring.day3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifeSupportRatingTest {

    private void setSystemIn(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void zeroBitReturnsO() {
        setSystemIn("0\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(0, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void oneBitReturns1() {
        setSystemIn("1\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(1, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void zeroOneBitsReturnsO() {
        setSystemIn("0\n1\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(0, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void oneZeroBitsReturnsO() {
        setSystemIn("1\n0\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(0, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void oneOneBitsReturns1() {
        setSystemIn("1\n1\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(1, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void zeroOneZeroBitsReturnsO() {
        setSystemIn("0\n1\n0\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(0, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void zeroZeroBitsReturns0() {
        setSystemIn("00\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(0, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void zeroOneBitsReturns1() {
        setSystemIn("01\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(1, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void oneZeroBitsReturns4() {
        setSystemIn("10\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(4, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void oneOneBitsReturns9() {
        setSystemIn("11\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(9, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void twoBitsReturns9() {
        setSystemIn("01\n10\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(2, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void twelve5bitsReturns230() {
        setSystemIn("00100\n11110\n10110\n10111\n10101\n01111\n00111\n11100\n10000\n11001\n00010\n01010\n");
        var lifeSupportRating = new LifeSupportRating(new Scanner(System.in));
        assertEquals(230, lifeSupportRating.computeOxygenCO2Multiplier());
    }

    @Test
    void computeLifeSupportRatingFromInput() throws FileNotFoundException {
        LifeSupportRating lifeSupportRating;
        File file = new File("src/main/resources/day3.txt");
        try(Scanner sc = new Scanner(file)) {
            if(sc.hasNext())
                lifeSupportRating = new LifeSupportRating(sc);
            else
                throw new IllegalStateException("No data found");

        }
        int result = lifeSupportRating.computeOxygenCO2Multiplier();
        assertEquals(6085575, result);
    }
}
