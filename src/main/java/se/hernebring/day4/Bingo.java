package se.hernebring.day4;

import java.util.*;

public class Bingo {

    private int left, current;

    private List<Map<Integer, Integer>> rows;

    private List<Set<Integer>> columns;

    public Bingo() {}
    public Bingo(int left) {
        this.left = left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public boolean play(int number) {
        current = number;
        boolean row = removeInRow();
        if(!row)
            return false;

        return removeInColumn();
    }

    private boolean removeInRow() {
        for (Map<Integer,Integer> r : rows) {
            if (r.size() <= 1) {
                if (r.containsValue(current)) {
                    left -= current;
                    return false;
                }

            } else {
                var it = r.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == current) {
                        it.remove();
                        left -= current;
                        return true;
                    }
                }
            }
        }
        return true;
    }

    private boolean removeInColumn() {
        for (Set<Integer> c : columns) {
            if (c.size() <= 1) {
                if (c.contains(current))
                    return false;

            } else {
                var it = c.iterator();
                while (it.hasNext()) {
                    if (it.next() == current) {
                        it.remove();
                        return true;
                    }
                }
            }
        }
        return true;
    }

    public void add(List<Map<Integer, Integer>> rows) {
        this.rows = rows;
        columns = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            Set<Integer> currentColumn = new HashSet<>();
            for (Map<Integer, Integer> row : rows)
                currentColumn.add(row.get(i));

            columns.add(currentColumn);
        }

    }

    public int result() {
        return left * current;
    }
}
