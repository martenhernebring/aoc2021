package se.hernebring.day1;

import java.util.ArrayList;
import java.util.List;

public class ThreeSlidingWindow {
    public static List<Integer> getMeasurements(List<Integer> m3) {
        if(m3.size() < 3)
            return null;

        List<Integer> m = new ArrayList<>();
        for(int i = 0; i < m3.size() - 2; i++)
            m.add(m3.get(i) + m3.get(i + 1) + m3.get(i + 2));

        return m;
    }
}
