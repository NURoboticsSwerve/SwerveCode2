
public class WheelModule {

    public static final double MAX_GEAR_SPEED = 0;

    private double topEncoderSpeed, botEncoderSpeed, topGearSetpoint, botGearSetpoint;
    private double encoderAngle, velSetpoint, angVelSetpoint;

    public WheelModule() {

    }

    /**
     * @brief Uses top and bottom gear setpoints to find velocity and angular velocity
     */
    public void findModuleSpeeds() {

    }

    /**
     * @brief Uses velocity and angular velocity setpoints to find top and bottom gear velocity setpoints
     */
    public void findGearSpeeds() {

    }

    /**
     * @brief Sets setpoint of top gear
     * @param setpoint Percentage 0-1
     */
    public void setTopGearSetpoint(double setpoint) {
        topGearSetpoint = setpoint;
    }

    /**
     * @brief Sets setpoint of bottom gear
     * @param setpoint Percentage 0-1
     */
    public void setBotGearSetpoint(double setpoint) {
        botGearSetpoint = setpoint;
    }

    /**
     * @brief Sets top encoder speed as percent of top speed
     * @param percent: Percent of max speed top encoder measured at
     */
    public void setTopEncoderSpeed(double percent) {

    }

    /**
     * @brief Sets bottom encoder speed as percent of top speed
     * @param percent: Percent of max speed bottom encoder measured at
     */
    public void setBotEncoderSpeed(double percent) {

    }

    /**
     * @brief Sets angle of bottom encoder
     * @param angle: Angle in ______ bound to -0.5 to 0.5 rotations
     */
    public void setEncoderAngle(double angle) {

    }

    /**
     * @brief Sets velocity setpoint of wheel
     * @param percent: Percent 0-1
     */
    public void setVelSetpoint(double percent) {

    }

    /**
     * @brief  Sets angular velocity setpoint of wheel
     * @param percent: Percent 0-1
     */
    public void setAngVelSetpoint(double percent) {

    }
}
