package se.hernebring.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinesOverlap {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/day5.txt");
        Field field = new Field(1000);
        try (Scanner sc = new Scanner(file)){
            while(sc.hasNext()) {
                field.add(sc.nextLine());
            }

        }
        System.out.println(field.getPoints());
    }
}
