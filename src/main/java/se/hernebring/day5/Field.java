package se.hernebring.day5;

public class Field {

    private int[][] field = new int[10][];

    public Field(int size) {
        field = new int[size][];
        for(int i = 0; i < field.length; i++)
            field[i] = new int[size];

    }

    public void add(String rawLine) {
        var splitCommas = rawLine.split("\\s*,\\s*");
        int x1 = Integer.parseInt(splitCommas[0]);
        var splitSpaces = splitCommas[1].split(("\\s+"));
        int y1 = Integer.parseInt(splitSpaces[0]);
        int x2 = Integer.parseInt(splitSpaces[2]);
        int y2 = Integer.parseInt(splitCommas[2]);
        if(x1 == x2) {
            if(y1 > y2) {
                for(int i = y2; i <= y1; i++) {
                    field[i][x1]++;
                }
            }
            else {
                for(int i = y1; i <= y2; i++) {
                    field[i][x1]++;
                }
            }
        }
        else if(y1 == y2) {
            if(x1 > x2) {
                for(int i = x2; i <= x1; i++) {
                    field[y1][i]++;
                }
            }
            else {
                for(int i = x1; i <= x2; i++) {
                    field[y1][i]++;
                }
            }
        }
    }

    public void showResult() {
        for(int[] l : field) {
            for(int p : l)
                System.out.print(p);

            System.out.println();
        }
    }

    public int getPoints() {
        int points = 0;
        for(int[] l : field) {
            for(int p : l) {
                if(p > 1)
                    points++;

            }
        }
        return points;
    }
}
