package alarm;

public class ConsoleAlarmChannel implements AlarmChannel {
    @Override
    public void alarm() {
        System.out.println("Alarm");
    }
}
