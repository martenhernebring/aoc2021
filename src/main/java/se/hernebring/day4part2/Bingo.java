package se.hernebring.day4part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/day4.txt");
        final int size = 5;
        List<Board> boards = new ArrayList<>();
        String draws;
        try(Scanner sc = new Scanner(file)) {
            draws = sc.next();
            while(sc.hasNext()) {
                List<Integer> b = new ArrayList<>();
                for(int i = 0; i < size * size; i++) {
                    b.add(sc.nextInt());
                }
                Board board = new Board(b, size);
                boards.add(board);
            }
        }
        var d = draws.split("\\s*,\\s*");
        var it = Arrays.stream(d).iterator();
        int boardsLeft = boards.size();
        while(boardsLeft > 0) {
            int n = Integer.parseInt(it.next());
            for(Board board : boards) {
                if(board.isPlaying()) {
                    boolean bingo = board.play(n);
                    if(bingo) {
                        boardsLeft--;
                        if(boardsLeft <= 0)
                            System.out.println(board.getResult());

                    }
                }
            }
        }
    }
}
