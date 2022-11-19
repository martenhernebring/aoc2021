package se.hernebring.day6;

public class LanternFish {

    private int timer;

    public LanternFish(int timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        return String.valueOf(timer);
    }

    public int decrease() {
        timer --;
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
}
