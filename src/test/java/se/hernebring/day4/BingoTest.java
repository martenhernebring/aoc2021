package se.hernebring.day4;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BingoTest {

    private List<Map<Integer,Integer>> createPlayer(int size) {
        List<Map<Integer,Integer>> p = new ArrayList<>();
        int number = 0;
        for(int row = 0; row < size; row++) {
            Map<Integer, Integer> current = new LinkedHashMap<>();
            for(int column = 0; column < size; column++) {
                current.put(column, number);
                number++;
            }
            p.add(current);
        }
        return p;
    }

    private int playLuckyFirstRow(int size) {
        Bingo bingo = new Bingo((size * size * (size * size - 1)) / 2);
        bingo.add(createPlayer(size));
        boolean play = true;
        for(int i = 0; play & i < size * size; i++)
            play = bingo.play(i);

        return bingo.result();
    }

    private int playLuckyFirstColumn() {
        Bingo bingo = new Bingo((2 * 2 * (2 * 2 - 1)) / 2);
        bingo.add(createPlayer(2));
        boolean play = true;
        for(int i = 0; play & i < 2 * 2; i += 2)
            play = bingo.play(i);

        return bingo.result();
    }

    @Test
    void oneUsingOneByOneRowAndColumnWin() {
        assertEquals(0, playLuckyFirstRow(1));
    }


    @Test
    void oneTwoUsingTwoByTwoRowWin() {
        assertEquals(5, playLuckyFirstRow(2));
    }

    @Test
    void oneTwoThreeUsingThreeByThreeRowWin() {
        assertEquals(66, playLuckyFirstRow(3));
    }

    @Test
    void oneThreeUsingTwoByTwoColumnWin() {
        assertEquals(8, playLuckyFirstColumn());
    }

    @Test
    void example() throws FileNotFoundException {
        List<Bingo> bingo = new ArrayList<>();
        File file = new File("src/main/resources/day4example.txt");
        String numbers;
        try(Scanner sc = new Scanner(file)) {
            if(sc.hasNext())
                 numbers = sc.next();
            else
                throw new IllegalStateException("No data found");

            while(sc.hasNext())
                bingo.add(createBingo(sc));

        }
        int winner = playUntilBingo(bingo, numbers);
        assertEquals(4512, bingo.get(winner).result());
    }

    @Test
    void losingExample() throws FileNotFoundException {
        List<Bingo> bingo = new ArrayList<>();
        File file = new File("src/main/resources/day4example.txt");
        String numbers;
        try(Scanner sc = new Scanner(file)) {
            if(sc.hasNext())
                numbers = sc.next();
            else
                throw new IllegalStateException("No data found");

            while(sc.hasNext())
                bingo.add(createBingo(sc));

        }
        Bingo b = playUntilLastResult(bingo, numbers);
        assertEquals(1924, b.result());
    }

    @Test
    void input() throws FileNotFoundException {
        List<Bingo> bingo = new ArrayList<>();
        File file = new File("src/main/resources/day4.txt");
        String numbers;
        try(Scanner sc = new Scanner(file)) {
            if(sc.hasNext())
                numbers = sc.next();
            else
                throw new IllegalStateException("No data found");

            while(sc.hasNext())
                bingo.add(createBingo(sc));

        }
        int winner = playUntilBingo(bingo, numbers);
        assertEquals(34506, bingo.get(winner).result());
    }

    @Test
    void losingInput() throws FileNotFoundException {
        List<Bingo> bingo = new ArrayList<>();
        File file = new File("src/main/resources/day4.txt");
        String numbers;
        try(Scanner sc = new Scanner(file)) {
            if(sc.hasNext())
                numbers = sc.next();
            else
                throw new IllegalStateException("No data found");

            while(sc.hasNext())
                bingo.add(createBingo(sc));

        }
        Bingo b = playUntilLastResult(bingo, numbers);
        assertTrue(b.result() < 6688);
    }

    private Bingo createBingo(Scanner sc) {
        Bingo b = new Bingo();
        final int size = 5;
        int left = 0;
        List<Map<Integer, Integer>> player = new ArrayList<>();
        for(int row = 0; row < size; row++) {
            Map<Integer, Integer> current = new LinkedHashMap<>();
            for(int column = 0; column < size; column++) {
                int n = sc.nextInt();
                current.put(column, n);
                left += n;
            }
            player.add(current);
        }
        b.add(player);
        b.setLeft(left);
        return b;
    }

    private int playUntilBingo(List<Bingo> bingo, String numbers) {
        var n = numbers.split("\\s*,\\s*");
        for (String s : n) {
            for (int j = 0; j < bingo.size(); j++) {
                boolean play = bingo.get(j).play(Integer.parseInt(s));
                if (!play)
                    return j;
            }
        }
        throw new IllegalStateException("Not proper bingo test");
    }

    private Bingo playUntilLastResult(List<Bingo> bingo, String numbers) {
        var n = numbers.split("\\s*,\\s*");
        var it = bingo.iterator();
        for (String s : n) {
            while(it.hasNext()) {
                Bingo b = it.next();
                boolean play = b.play(Integer.parseInt(s));
                if (!play) {
                    if(bingo.size() > 1)
                        it.remove();
                    else
                        return b;
                }
            }
        }
        throw new IllegalStateException("Not proper bingo test");
    }
}
