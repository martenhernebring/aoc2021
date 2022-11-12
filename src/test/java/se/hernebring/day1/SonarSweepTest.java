package se.hernebring.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SonarSweepTest {

    private List<Integer> measurements;
    
    @BeforeEach
    void init() {
        measurements = new ArrayList<>();
    }

    @Test
    void noPreviousMeasurementReturnsMinusOne() {
        measurements.add(199);
        int result = SonarSweep.largerMeasurements(measurements);
        assertEquals(-1, result);
    }

    @Test
    void noPreviousMeasurementSmallerReturnsZero() {
        measurements.add(199);
        measurements.add(100);
        int result = SonarSweep.largerMeasurements(measurements);
        assertEquals(0, result);
    }

    @Test
    void onePreviousMeasurementBiggerReturnsOne() {
        measurements.add(199);
        measurements.add(200);
        int result = SonarSweep.largerMeasurements(measurements);
        assertEquals(1, result);
    }

    @Test
    void twoPreviousMeasurementBiggerReturnsTwo() {
        measurements.add(199);
        measurements.add(200);
        measurements.add(208);
        int result = SonarSweep.largerMeasurements(measurements);
        assertEquals(2, result);
    }

    @Test
    void fourPreviousMeasurementBiggerThanThePreviousReturnsFour() {
        measurements.add(199);
        measurements.add(200);
        measurements.add(208);
        measurements.add(210);
        measurements.add(200);
        measurements.add(207);
        int result = SonarSweep.largerMeasurements(measurements);
        assertEquals(4, result);
    }

    @Test
    void inputPreviousMeasurementBiggerThanThePreviousReturnsOneThousandThreeHundredAndOne() throws FileNotFoundException {
        File file = new File("src/main/resources/day1.txt");
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNext())
                measurements.add(sc.nextInt());

        }
        int result = SonarSweep.largerMeasurements(measurements);
        assertEquals(1301, result);
    }

    @Test
    void invalidThreeMeasurementSlidingWindowThrowsNullPointer() {
        List<Integer> m3 = new ArrayList<>();
        m3.add(199);
        m3.add(200);
        measurements = ThreeSlidingWindow.getMeasurements(m3);
        assertThrows(NullPointerException.class, () -> SonarSweep.largerMeasurements(measurements));
    }

    @Test
    void oneThreeMeasurementSlidingWindowReturnMinusOne() {
        List<Integer> m3 = new ArrayList<>();
        m3.add(199);
        m3.add(200);
        m3.add(208);
        measurements = ThreeSlidingWindow.getMeasurements(m3);
        int result = SonarSweep.largerMeasurements(measurements);
        assertEquals(-1, result);
    }

    @Test
    void oneIncreasedThreeMeasurementSlidingWindowReturnOne() {
        List<Integer> m3 = new ArrayList<>();
        m3.add(199);
        m3.add(200);
        m3.add(208);
        m3.add(210);
        m3.add(200);
        m3.add(207);
        measurements = ThreeSlidingWindow.getMeasurements(m3);
        int result = SonarSweep.largerMeasurements(measurements);
        assertEquals(1, result);
    }

    @Test
    void inputThreeMeasurementSlidingWindowReturnOneThousandThreeHundredFortySix() throws FileNotFoundException {
        File file = new File("src/main/resources/day1.txt");
        List<Integer> m3 = new ArrayList<>();
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNext())
                m3.add(sc.nextInt());

        }
        int result = SonarSweep.largerMeasurements(
                Objects.requireNonNull(ThreeSlidingWindow.getMeasurements(m3))
        );
        assertEquals(1346, result);
    }
}
