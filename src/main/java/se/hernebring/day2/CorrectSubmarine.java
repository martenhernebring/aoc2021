package se.hernebring.day2;

public class CorrectSubmarine {
    private int horizontalPosition = 0;
    private int depth = 0;
    private int aim;

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    public void forward(int units) {
        this.horizontalPosition += units;
        this.depth += aim * units;
    }

    public void down(int aim) {
        this.aim += aim;
    }

    public void up(int aim) {
        if(aim > this.aim)
            throw new IllegalStateException("Aim cannot be negative");

        this.aim -= aim;
    }

    public int getAim() {
        return aim;
    }
}
