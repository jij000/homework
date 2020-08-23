package bank.proxy;

public class Timer {
    private long start = 0;
    private long finish = 0;
    private long timeElapsed = 0;
    public void start() {
        start = System.nanoTime();
    }
    public void stop() {
        finish = System.nanoTime();
    }
    public long getNanoTime() {
        timeElapsed = finish - start;
        return timeElapsed;
    }
}
