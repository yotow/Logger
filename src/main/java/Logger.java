import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger instance;
    protected int num = 1;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    public void log(String msg) {
        System.out.println("[" + getCurrentDate() + " " + num++ + "] " + msg);
    }
}
