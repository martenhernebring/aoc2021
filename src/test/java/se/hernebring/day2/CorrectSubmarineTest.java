package se.hernebring.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CorrectSubmarineTest {

    private CorrectSubmarine correctSubmarine;

    @BeforeEach
    void init() {
        correctSubmarine = new CorrectSubmarine();
    }

    @Test
    void horizontalPositionAndDepthBothStartsWithZero() {
        assertEquals(0, correctSubmarine.getHorizontalPosition());
        assertEquals(0, correctSubmarine.getDepth());
        assertEquals(0, correctSubmarine.getAim());
    }

    @Test
    void forward5AtStartAdds5ToHorizontalPosition() {
        correctSubmarine.forward(5);
        assertEquals(5, correctSubmarine.getHorizontalPosition());
    }

    @Test
    void down5Adds5ToAim() {
        correctSubmarine.down(5);
        assertEquals(5, correctSubmarine.getAim());
    }

    @Test
    void forward8AfterDown5Adds8ToHorizontalPositionAndIncreaseDepthBy40() {
        correctSubmarine.down(5);
        correctSubmarine.forward(8);
        assertEquals(8, correctSubmarine.getHorizontalPosition());
        assertEquals(40, correctSubmarine.getDepth());
    }

    @Test
    void up3AtStartThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> correctSubmarine.up(3));
    }

    @Test
    void down5AndThenUp3IsOk() {
        correctSubmarine.down(5);
        correctSubmarine.up(3);
        assertEquals(2, correctSubmarine.getAim());
    }

    @Test
    void inputAndThenMultiplySubmarineValues() throws FileNotFoundException {
        File file = new File("src/main/resources/day2.txt");
        CorrectSubmarine s = new CorrectSubmarine();
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
