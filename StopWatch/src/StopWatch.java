import java.util.concurrent.TimeUnit;

public class StopWatch extends Thread {
    public boolean proceed;
    private int i;

    public StopWatch() {
        i = 1;
        proceed = true;
    }

    @Override
    public void run() {
        while (true) {
            while (proceed) {
                if (Thread.interrupted()) {
                    return;
                }
                System.out.println(i++);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    return;
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
}
