import java.util.*;

public class ControlStopWatch {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StopWatch stopWatch = new StopWatch();
        while (!input.equals("s")) { // user enters s for stop
            if (input.equals("start")) { // user must enter start in the beginning
                stopWatch.start();
                stopWatch.join(100);
            }
            if (input.equals("p")) { // user enters p for pause
                System.out.println("Stopwatch paused");
                stopWatch.proceed = false;
            }
            if (input.equals("r")) { // user enters r for resume
                System.out.println("Stopwatch resumed");
                stopWatch.proceed = true;
            }
            if (scanner.hasNextLine()) {
                input = scanner.next();
            }
        }
        System.out.println("Stopwatch stopped");
        stopWatch.interrupt();
    }
}
