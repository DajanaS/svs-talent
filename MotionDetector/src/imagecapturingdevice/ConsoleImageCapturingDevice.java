package imagecapturingdevice;

import java.util.*;

public class ConsoleImageCapturingDevice implements ImageCapturingDevice {
    private Scanner scanner;

    public ConsoleImageCapturingDevice() {
        scanner = new Scanner(System.in);
    }

    public byte[] captureImage() {
        return scanner.nextLine().getBytes();
    }
}
