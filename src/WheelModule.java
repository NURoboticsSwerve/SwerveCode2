
public class WheelModule {

    public static final double MAX_GEAR_SPEED = 0;

    private double topEncoderSpeed, botEncoderSpeed, topGearSetpoint, botGearSetpoint;
    private double encoderAngle, velSetpoint, angVelSetpoint, angSetpoint;
    private short rotXDefault, rotYDefault;

    public static WheelModule wheels[] = new WheelModule[4];

    /**
     * @brief Constructor to create new wheel module object
     * @param rotXDefault: Default x rotation multiplier (-1 or 1)
     * @param rotYDefault: Default y rotation multiplier (-1 or 1)
     */
    public WheelModule(short rotXDefault, short rotYDefault) {
        this.rotXDefault = rotXDefault;
        this.rotYDefault = rotYDefault;
    }

    /**
     * @brief Sets the motor speeds of a wheel module at the motor controller level
     *
     * @param topPercent: Percent of max speed to set top gear as
     * @param botPercent: Percent of max speed to set bottom gear as
     */
    void setMotorSpeed(double topPercent, double botPercent) {

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
     * @brief Gets default rotation sign multiplier in x direction
     */
    public short getRotXDefault() {
        return rotXDefault;
    }

    /**
     * @brief Gets default rotation sign multiplier in y direction
     */
    public short getRotYDefault() {
        return rotYDefault;
    }

    /**
     * @brief Sets setpoint of top gear
     * @param setpoint Percentage 0-1
     */
    public void setTopGearSetpoint(double setpoint) {
        this.topGearSetpoint = setpoint;
    }

    /**
     * @brief Sets setpoint of bottom gear
     * @param setpoint Percentage 0-1
     */
    public void setBotGearSetpoint(double setpoint) {
        this.botGearSetpoint = setpoint;
    }

    /**
     * @brief Sets top encoder speed as percent of top speed
     * @param percent: Percent of max speed top encoder measured at
     */
    public void setTopEncoderSpeed(double percent) {
        this.topEncoderSpeed = percent;
    }

    /**
     * @brief Sets bottom encoder speed as percent of top speed
     * @param percent: Percent of max speed bottom encoder measured at
     */
    public void setBotEncoderSpeed(double percent) {
        this.botEncoderSpeed = percent;
    }

    /**
     * @brief Sets angle of bottom encoder
     * @param angle: Angle in radians bound to -PI to PI rotations
     */
    public void setEncoderAngle(double angle) {
        this.encoderAngle = angle;
    }

    /**
     * @brief Sets velocity setpoint of wheel
     * @param percent: Percent 0-1
     */
    public void setVelSetpoint(double percent) {
        this.velSetpoint = percent;
    }

    /**
     * @brief  Sets angular velocity setpoint of wheel
     * @param percent: Percent 0-1
     */
    public void setAngVelSetpoint(double percent) {
        this.angVelSetpoint = percent;
    }

    /**
     * @brief Sets angle setpoint of wheel
     * @param angle: Angle in radians bound to -PI to PI rotations
     */
    public void setAngSetpoint(double angle) {
        this.angSetpoint = angle;
    }
}
