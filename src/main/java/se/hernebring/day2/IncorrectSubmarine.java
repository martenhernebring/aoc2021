package se.hernebring.day2;

public class IncorrectSubmarine {
    private int horizontalPosition = 0;
    private int depth = 0;

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    public void forward(int horizontalPosition) {
        this.horizontalPosition += horizontalPosition;
    }

    public void down(int depth) {
        this.depth += depth;
    }

    public void up(int depth) {
        if(depth > this.depth)
            throw new IllegalStateException("Submarine cannot be above water");

        this.depth -= depth;
    }
}
