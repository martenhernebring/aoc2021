package se.hernebring.day1;

import java.util.List;

public class SonarSweep {
    public static int largerMeasurements(List<Integer> measurement) {
        int size = measurement.size();
        if(size <= 1)
            return -1;

        int largerMeasurements = 0;
        for(int i = 1; i < size; i++) {
            if(measurement.get(i) > measurement.get(i - 1))
                largerMeasurements++;

        }
        return largerMeasurements;
    }
}
