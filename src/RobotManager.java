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

        /* Initialize wheel modules */


        /* Initialize connection to XBox controller */
        XboxControllerManager.initXboxController();

    }

    /**
     * @brief Controls main looping of robot. Calls all tasks in appropriate order
     */
    private static void loopRobot() {

        /* Tasks if robot is enabled */
        if (robotEnabled) {

            /* Disable robot if the controller is not connected */
            if (!XboxControllerManager.isXboxControllerConnected()) {
                disableRobot();
                return;
            }



        }

        /* Tasks if robot is disabled */
        else {


        }

    }

    /**
     * @brief All information sent to GUI through swerve dashboard
     */
    private static void sendDebugInfo() {

    }

    /**
     * @brief Sets enabled state of robot to true
     */
    public static void enableRobot() {

        /* Sets robot state to enabled */
        robotEnabled = true;
    }

    /**
     * @brief Performs all tasks necessary upon robot disabling
     */
    public static void disableRobot() {

        /* Set state of robot to disabled */
        robotEnabled = false;

        /* Turn off all motors */
        for (int i = 0; i < WheelModule.wheels.length; i++)
            WheelModule.wheels[i].setMotorSpeed(0, 0);
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
