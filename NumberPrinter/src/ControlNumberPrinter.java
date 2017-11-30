public class ControlNumberPrinter {
    private static final int interval = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread numberPrinterThread = new Thread(new NumberPrinter());
        numberPrinterThread.start();
        numberPrinterThread.join(interval);
        numberPrinterThread.interrupt();
    }
}