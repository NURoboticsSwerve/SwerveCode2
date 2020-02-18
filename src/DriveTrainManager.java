/**
 * @file DriveTrainManager.java
 *
 * @brief Performs all drive train math and high-level motor/motor controller functions
 */

public class DriveTrainManager {

    /**
     * @brief Given robot theoretical setpoints
     * Finds WheelModule velocity setpoint and angle setpoint for each wheel (relative to field centric)
     *
     * @param x: Robot x velocity setpoint 0-1
     * @param y: Robot y velocity setpoint 0-1
     * @param rot: Robot rotational velocity setpoint 0-1
     */
    static void findModuleSpeeds(double x, double y, double rot) {

        double xVel, yVel, vel, ang;

        for (int i = 0; i < WheelModule.wheels.length; i++) {

            /* Calculate setpoints for velocity and angle */
            xVel = x + Math.sin(Math.atan2(WheelModule.wheels[i].getRotXDefault(),
                                            WheelModule.wheels[i].getRotYDefault()));
            yVel = y + Math.cos(Math.atan2(WheelModule.wheels[i].getRotXDefault(),
                                            WheelModule.wheels[i].getRotYDefault()));

            vel = Math.sqrt(Math.pow(xVel, 2) + Math.pow(yVel, 2.0));
            ang = Math.atan2(xVel, yVel);

            WheelModule.wheels[i].setVelSetpoint(vel);
            WheelModule.wheels[i].setAngSetpoint(ang);
        }

    }

    /**
     * @brief Finds maximum gear percent setpoint of all wheels' gears
     * If max percent > 1, divides all gear percentages to be less than 1
     */
    static void limitMaxGearSpeed() {

    }

}
