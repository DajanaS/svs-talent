package motiondetector;

import alarm.*;
import image.Image;
import imagecapturingdevice.*;

import java.util.concurrent.TimeUnit;

public class MotionDetector extends Thread {
    private AlarmChannel[] alarms;
    private ConsoleImageCapturingDevice imageCapturingDevice;
    private Image prevImg;

    public MotionDetector() {
        alarms = new AlarmChannel[1];
        alarms[0] = new ConsoleAlarmChannel();
        imageCapturingDevice = new ConsoleImageCapturingDevice();
    }

    @Override
    public void run() {
        prevImg = new Image(imageCapturingDevice.captureImage());

        while (true) {
            if (Thread.interrupted()) {
                return;
            }

            Image currImg = new Image(imageCapturingDevice.captureImage());
            if (!currImg.equals(prevImg)) {
                for (AlarmChannel alarm : alarms) {
                    alarm.alarm();
                }
            }
            prevImg = currImg;

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
