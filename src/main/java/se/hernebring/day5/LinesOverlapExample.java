package se.hernebring.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinesOverlapExample {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/day5example.txt");
        Field field = new Field(10);
        try (Scanner sc = new Scanner(file)){
            while(sc.hasNext()) {
                field.add(sc.nextLine());
            }

        }
        field.showResult();
        System.out.println(field.getPoints());
    }
}
