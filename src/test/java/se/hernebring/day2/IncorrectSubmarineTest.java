package se.hernebring.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IncorrectSubmarineTest {

    private IncorrectSubmarine incorrectSubmarine;

    @BeforeEach
    void init() {
        incorrectSubmarine = new IncorrectSubmarine();
    }

    @Test
    void horizontalPositionAndDepthBothStartsWithZero() {
        assertEquals(0, incorrectSubmarine.getHorizontalPosition());
        assertEquals(0, incorrectSubmarine.getDepth());
    }

    @Test
    void forward5Adds5ToHorizontalPosition() {
        incorrectSubmarine.forward(5);
        assertEquals(5, incorrectSubmarine.getHorizontalPosition());
    }

    @Test
    void down5Adds5ToDepth() {
        incorrectSubmarine.down(5);
        assertEquals(5, incorrectSubmarine.getDepth());
    }

    @Test
    void forward8Adds8ToHorizontalPosition() {
        incorrectSubmarine.forward(8);
        assertEquals(8, incorrectSubmarine.getHorizontalPosition());
    }

    @Test
    void up3AtStartThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> incorrectSubmarine.up(3));
    }

    @Test
    void down5AndThenUp3IsOk() {
        incorrectSubmarine.down(5);
        incorrectSubmarine.up(3);
        assertEquals(2, incorrectSubmarine.getDepth());
    }

    @Test
    void inputAndThenMultiplySubmarineValues() throws FileNotFoundException {
        File file = new File("src/main/resources/day2.txt");
        IncorrectSubmarine s = new IncorrectSubmarine();
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String method = sc.next();
                int modifier = sc.nextInt();
                switch (method) {
                    case "forward" -> s.forward(modifier);
                    case "down" -> s.down(modifier);
                    case "up" -> s.up(modifier);
                    default -> throw new IllegalStateException("Illegal method");
                }
            }
        }
        System.out.println(s.getHorizontalPosition() * s.getDepth());
    }
}
