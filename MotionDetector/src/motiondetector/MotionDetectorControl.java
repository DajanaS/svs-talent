package motiondetector;

public class MotionDetectorControl {
    public static void main(String[] args) throws InterruptedException {
        MotionDetector motionDetector = new MotionDetector();
        motionDetector.start();
        motionDetector.join(50000);
        motionDetector.interrupt();
    }
}
