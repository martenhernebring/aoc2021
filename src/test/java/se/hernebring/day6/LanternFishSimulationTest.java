package se.hernebring.day6;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanternFishSimulationTest {

    @Test
    void initialState() throws FileNotFoundException {
        File file = new File("src/main/resources/day6example.txt");
        try(Scanner scanner = new Scanner(file)) {
            String data = scanner.nextLine();
            LanternFishSimulation lanternFishSimulation = new LanternFishSimulation(data);
            assertEquals("3,4,3,1,2", lanternFishSimulation.current());
        }
    }

    @Test
    void afterDay1() throws FileNotFoundException {
        File file = new File("src/main/resources/day6example.txt");
        try(Scanner scanner = new Scanner(file)) {
            String data = scanner.nextLine();
            LanternFishSimulation lanternFishSimulation = new LanternFishSimulation(data);
            lanternFishSimulation.after(1);
            assertEquals("2,3,2,0,1", lanternFishSimulation.current());
        }
    }

    @Test
    void afterDay2() throws FileNotFoundException {
        File file = new File("src/main/resources/day6example.txt");
        try(Scanner scanner = new Scanner(file)) {
            String data = scanner.nextLine();
            LanternFishSimulation lanternFishSimulation = new LanternFishSimulation(data);
            lanternFishSimulation.after(2);
            assertEquals("1,2,1,6,0,8", lanternFishSimulation.current());
        }
    }

    @Test
    void afterDay3() throws FileNotFoundException {
        File file = new File("src/main/resources/day6example.txt");
        try(Scanner scanner = new Scanner(file)) {
            String data = scanner.nextLine();
            LanternFishSimulation lanternFishSimulation = new LanternFishSimulation(data);
            lanternFishSimulation.after(3);
            assertEquals("0,1,0,5,6,7,8", lanternFishSimulation.current());
        }
    }

    @Test
    void afterDay18() throws FileNotFoundException {
        File file = new File("src/main/resources/day6example.txt");
        try(Scanner scanner = new Scanner(file)) {
            String data = scanner.nextLine();
            LanternFishSimulation lanternFishSimulation = new LanternFishSimulation(data);
            lanternFishSimulation.after(18);
            assertEquals("6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8,8,8,8",
                    lanternFishSimulation.current());
            assertEquals(26, lanternFishSimulation.getTotal());
        }
    }

    @Test
    void afterDay80() throws FileNotFoundException {
        File file = new File("src/main/resources/day6example.txt");
        try(Scanner scanner = new Scanner(file)) {
            String data = scanner.nextLine();
            LanternFishSimulation lanternFishSimulation = new LanternFishSimulation(data);
            lanternFishSimulation.after(80);
            assertEquals(5934, lanternFishSimulation.getTotal());
        }
    }

    @Test
    void afterDay80integration() throws FileNotFoundException {
        File file = new File("src/main/resources/day6.txt");
        try(Scanner scanner = new Scanner(file)) {
            String data = scanner.nextLine();
            LanternFishSimulation lanternFishSimulation = new LanternFishSimulation(data);
            lanternFishSimulation.after(80);
            assertEquals(380243, lanternFishSimulation.getTotal());
        }
    }
}
