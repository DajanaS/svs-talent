public class NumberPrinter implements Runnable {
    private static final int limit = 1000000;

    @Override
    public void run() {
        for (int i = 0; i <= limit; i++) {
            if (Thread.interrupted()) {
                return;
            }
            System.out.println(i);
        }
    }
}