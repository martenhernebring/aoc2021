package se.hernebring.day3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryDiagnosticTest {

    private void setSystemIn(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void initializeWith4InBinaryUsing5Bits() {
        setSystemIn("00100\n");
        var binaryDiagnostic = new BinaryDiagnostic(new Scanner(System.in));
        assertEquals(4, binaryDiagnostic.getCurrent());
        assertEquals(5, binaryDiagnostic.getBits());
    }

    @Test
    void mostCommon3returns22Times9() {
        setSystemIn("00100\n11110\n10110\n");
        var binaryDiagnostic = new BinaryDiagnostic(new Scanner(System.in));
        assertEquals(22 * 9, binaryDiagnostic.computeGammaEpsilonMultiplier());
    }

    @Test
    void mostCommon5returns22Times9() {
        setSystemIn("00100\n11110\n10110\n10111\n10101\n");
        var binaryDiagnostic = new BinaryDiagnostic(new Scanner(System.in));
        assertEquals(22 * 9, binaryDiagnostic.computeGammaEpsilonMultiplier());
    }

    @Test
    void mostCommon7returns23Times8() {
        setSystemIn("00100\n11110\n10110\n10111\n10101\n01111\n00111\n");
        var binaryDiagnostic = new BinaryDiagnostic(new Scanner(System.in));
        assertEquals(23 * 8, binaryDiagnostic.computeGammaEpsilonMultiplier());
    }

    @Test
    void mostCommon12returns22Times9() {
        setSystemIn("00100\n11110\n10110\n10111\n10101\n01111\n00111\n11100\n10000\n11001\n00010\n01010\n");
        var binaryDiagnostic = new BinaryDiagnostic(new Scanner(System.in));
        assertEquals(22 * 9, binaryDiagnostic.computeGammaEpsilonMultiplier());
    }

    @Test
    void computeGammaEpsilonMultiplierFromInput() throws FileNotFoundException {
        BinaryDiagnostic binaryDiagnostic;
        File file = new File("src/main/resources/day3.txt");
        try(Scanner sc = new Scanner(file)) {
            if(sc.hasNext())
                binaryDiagnostic = new BinaryDiagnostic(sc);
            else
                throw new IllegalStateException("No data found");

        }
        int result = binaryDiagnostic.computeGammaEpsilonMultiplier();
        System.out.println(result);
    }

}
