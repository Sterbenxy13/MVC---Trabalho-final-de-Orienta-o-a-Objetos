
package logger;

/**
 *
 * @author Sterbenxy13
 */
public class Logger {
    private static boolean enable = false;
    
    public static void setEnable(boolean canLog) {
        enable = canLog;
    }
    
    public static void log(String message) {
        System.out.println(message);
    }
    
}
