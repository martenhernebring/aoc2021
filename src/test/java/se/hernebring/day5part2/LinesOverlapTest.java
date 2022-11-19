package se.hernebring.day5part2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LinesOverlapTest {

    @Test
    void integration() throws FileNotFoundException {
        File file = new File("src/main/resources/day5.txt");
        Field field = new Field(1000);
        try (Scanner sc = new Scanner(file)){
            while(sc.hasNext()) {
                field.add(sc.nextLine());
            }
        }
        assertTrue(field.getPoints() > 21075);
    }
}
