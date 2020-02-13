import java.util.Timer;
import java.util.TimerTask;

/**
 * @file RobotManager.c
 *
 * @brief Controls all initializations and loops
 * Starts necessary threads
 */
public class RobotManager extends TimerTask {

    private static final long LOOP_PERIOD_MS = 10;

    private final Timer mainTimer;
    private static boolean robotEnabled;

    /**
     * @brief Constructor that creates new TimerTask
     */
    public RobotManager() {

        /* Initialize robot */
        initRobot();

        /* Start all new threads */
        (new XboxControllerManager()).start();

        mainTimer = new Timer();
        mainTimer.schedule(this, (long) 0, LOOP_PERIOD_MS);
    }

    /**
     * @brief Performs all initializations of connected devices.
     * These include XBox controller, Teensy, and GUI
     * Calls all zeroing needed at robot initialization
     */
    private static void initRobot() {

        XboxControllerManager.initXboxController();

    }

    /**
     * @brief Controls main looping of robot. Calls all tasks in appropriate order
     */
    private static void loopRobot() {

    }

    /**
     * @brief All information sent to GUI through swerve dashboard
     */
    private static void sendDebugInfo() {

    }

    /**
     * @brief Sets enabled state of robot
     * @param enable: Boolean whether to enable or disable robot
     */
    public static void enableRobot(boolean enable) {

        /* Set enabled state of robot based on boolean parameter */
        robotEnabled = enable;
    }

    /**
     * @brief Gets whether robot is enabled or not
     * @return Boolean whether robot is enabled
     */
    public static boolean isRobotEnabled() {
        return robotEnabled;
    }

    @Override
    /**
     * @brief Runs loopRobot every LOOP_PERIOD_MS
     */
    public void run() {
        loopRobot();
    }

    /**
     * @brief Main class that creates instance of RobotManager
     */
    public static void main(String[] args) {
        new RobotManager();
    }
}
