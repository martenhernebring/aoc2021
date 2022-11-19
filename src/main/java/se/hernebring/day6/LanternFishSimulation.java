package se.hernebring.day6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LanternFishSimulation {
    private LinkedList<LanternFish> fish;

    public LanternFishSimulation(String data) {
        fish = Arrays.stream((data.split(",")))
                .map(Integer::parseInt)
                .map(LanternFish::new)
                .collect(Collectors.toCollection(LinkedList::new));;
    }

    public String current() {
        return fish.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    public void after(int days) {
        for(int i = 0; i < days; i++) {
            AtomicInteger created = new AtomicInteger();
            fish.forEach(lf -> {
                int timer = lf.decrease();
                if(timer < 0) {
                    lf.setTimer(6);
                    created.getAndIncrement();
                }
            });
            for(int j = 0; j < created.get(); j++)
                fish.add(new LanternFish(8));

        }
    }

    public long getTotal() {
        return fish.size();
    }
}
