package Speed;

public class RunTime {
    private long startTime;
    private long endTime;

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public void stopTimer() {
        endTime = System.currentTimeMillis();
    }

    public void print() {
        System.out.println("Runtime in millisecond is " + (double)(endTime - startTime));
    }
}