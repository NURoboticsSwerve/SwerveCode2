/**
 * @file DriveTrainManager.java
 *
 * @brief Performs all drive train math and high-level motor/motor controller functions
 */

public class DriveTrainManager {

    /**
     * @brief Given robot theoretical setpoints
     * Finds WheelModule velocity setpoint and angular velocity setpoint for each wheel
     *
     * @param x: Robot x velocity setpoint 0-1
     * @param y: Robot y velocity setpoint 0-1
     * @param rot: Robot rotational velocity setpoint 0-1
     */
    static void findModuleSpeeds(double x, double y, double rot) {

    }

    /**
     * @brief Finds maximum gear percent setpoint of all wheels' gears
     * If max percent > 1, divides all gear percentages to be less than 1
     */
    static void limitMaxGearSpeed() {

    }

    /**
     * @brief Sets the motor speeds of a wheel module at the motor controller level
     *
     * @param wheel: Wheel module to set motor speed of
     * @param topPercent: Percent of max speed to set top wheel as
     * @param botPercent: Percent of max speed to set bottom wheel as
     */
    static void setMotorSpeed(WheelModule wheel, double topPercent, double botPercent) {

    }

}
