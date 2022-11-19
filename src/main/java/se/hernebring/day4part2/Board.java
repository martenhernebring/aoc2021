package se.hernebring.day4part2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Board {
    private boolean playing = true;
    private final List<List<Integer>> rows;
    private final List<List<Integer>> columns;

    private int last = -1;

    public Board(List<Integer> b, int size) {
        rows = new ArrayList<>(b.size() / size);
        columns = new ArrayList<>(b.size() / size);
        for(int i = 0; i < size; i++) {
            List<Integer> r = new ArrayList<>();
            List<Integer> c = new ArrayList<>();
            for(int j = 0; j < size; j++) {
                r.add(b.get(i * size + j));
                c.add(b.get(i + size * j));
            }
            rows.add(r);
            columns.add(c);
        }
    }

    public boolean isPlaying() {
        return playing;
    }

    public boolean play(int n) {
        try {
            playRow(n);
        } catch (NoSuchElementException ex) {
            return !playing;
        }
        if(playing)
            playColumn(n);

        return !playing;
    }

    public void playRow(int n) {
        for(List<Integer> r : rows) {
            for(int i = 0; i < r.size(); i++) {
                if(n == r.get(i)) {
                    if(r.size() == 1) {
                        r.remove(0);
                        last = n;
                        playing = false;
                    } else
                        r.remove(i);

                    return;
                }
            }
        }
        throw new NoSuchElementException();
    }

    private void playColumn(int n) {
        for(List<Integer> c : columns) {
            for(int i = 0; i < c.size(); i++) {
                if(n == c.get(i)) {
                    if(c.size() == 1) {
                        c.remove(0);
                        last = n;
                        playing = false;
                    } else
                        c.remove(i);

                    return;
                }
            }
        }
        throw new NoSuchElementException();
    }

    public int getResult() {
        int left = 0;
        for(List<Integer> r : rows) {
            for(int l : r)
                left += l;

        }
        return left * last;
    }
}
