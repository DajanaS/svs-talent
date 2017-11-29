// this class would go in separate file Control.java
class Control {
    private static final int interval = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread numberPrinterThread = new Thread(new NumberPrinter());
        numberPrinterThread.start();
        numberPrinterThread.join(interval);
        numberPrinterThread.interrupt();
    }
}


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
