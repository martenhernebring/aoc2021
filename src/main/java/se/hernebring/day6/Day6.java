package se.hernebring.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day6 {
    public static void main(String args[]) throws FileNotFoundException {
        long[] count = new long[9];
        File inputFile = new File("src/main/resources/day6.txt");
        Scanner scan = new Scanner(inputFile);
        String[] input = scan.nextLine().split(",");
        scan.close();
        for(String f : input)
            count[Integer.parseInt(f)]++;

        System.out.println(solution(count, 256));//change 256 to 80 for part 1 solution
    }
    public static long solution(long[] fishes, int amount) {
        for(int i = 0; i < amount ; i++) {
            long newFish = fishes[0];
            for(int fish = 1; fish < fishes.length ; fish++) {
                fishes[fish - 1] = fishes[fish];
                fishes[fish] = 0;
            }
            fishes[8]+= newFish;
            fishes[6]+= newFish;
        }
        return Arrays.stream(fishes).sum();
    }
}
