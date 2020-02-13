/**
 * @file XboxControllerManager
 *
 * @brief Controls connection and inputs from XboxController
 */
public class XboxControllerManager extends Thread {

    public static final int XBOX_CONNECT_TIMEOUT_MS = 5000;
    public static final long XBOX_THREAD_SLEEP_MS = 20;

    private static boolean xboxControllerConnected = false;
    private static int xboxLeftX, xboxLeftY, xboxRightX;

    /**
     * @brief Waits timeout for connection to Xbox controller
     * @return Whether the connection to the Xbox controller was successful
     */
    public static boolean initXboxController() {

        /* Exit if the robot isn't enabled */
        if (!RobotManager.isRobotEnabled())
            return false;

        return true;
    }

    /**
     * @brief Whether xbox controller is currently connected
     * @return Boolean storing xbox connected state
     */
    public static boolean isXboxControllerConnected() {
        return xboxControllerConnected;
    }

    /**
     * @brief Gets value of xbox controller left joystick x axis
     * @return Value 0-1
     */
    public synchronized double getXboxLeftX() {
        return xboxLeftX;
    }

    /**
     * @brief Gets value of xbox controller right joystick y axis
     * @return Value 0-1
     */
    public synchronized double getXboxLeftY() {
        return xboxLeftY;
    }

    /**
     * @brief Gets value of xbox controller right joystick x axis
     * @return Value 0-1
     */
    public synchronized double getXboxRightX() {
        return xboxRightX;
    }

    /**
     * @brief Sets xbox controller left x axis value
     */
    public synchronized void setXboxLeftX() {

    }

    /**
     * @brief Sets xbox controller left y axis value
     */
    public synchronized void setXboxLeftY() {

    }

    /**
     * @brief Sets xbox controller right x axis value
     */
    public synchronized void setXboxRightX() {

    }

    /**
     * @brief Runs Xbox controller thread
     */
    public void run() {

        try {

            /* Sleep to not hog system but uns fast enough */
            Thread.sleep(XBOX_THREAD_SLEEP_MS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
