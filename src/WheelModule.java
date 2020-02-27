
public class WheelModule {

    public static final double WHEEL_RADIUS = 1; // In meters
    public static final double MAX_GEAR_SPEED = 1; // In rad/s
    // Angle at which the (angle off)^2 function hits vel percent of 1.00
    public static final double MAX_ANG_VEL_ANGLE = Math.PI;
    // Minimum angular velocity percent needed to have module move (overcome static friction )
    public static final double MIN_ANG_VEL_PERCENT = 0.03;
    // Gear ratio from sandwich gear (inner) to bevel gear (floating gear)
    public static final double SANDWICH_BEVEL_RATIO = 82.0/21;

    // Feedback variables
    public static final double MIN_GEAR_MOVE_PERCENT = 0;

    private double topEncoderSpeed, botEncoderSpeed, topGearSetpoint, botGearSetpoint; // m/s (2), % (2)
    private double encoderAngle, velSetpoint, angVelSetpoint, angSetpoint; // rad, %, %, rad
    private int rotXDefault = 1, rotYDefault = 1;

    /* Initialize wheels and enum that corresponds to wheel */
    public static WheelModule wheels[] = new WheelModule[4];
    public enum wheelLocation {frontLeft, frontRight, backLeft, backRight};

    /**
     * @brief Constructor to create new wheel module object
     * @param rotXDefaultPos: Whether x rotation multiplier is positive
     * @param rotYDefaultPos: Whether y rotation multiplier is positive
     */
    public WheelModule(boolean rotXDefaultPos, boolean rotYDefaultPos) {
        if (!rotXDefaultPos)
            rotXDefault = -1;
        if (!rotYDefaultPos)
            rotYDefault = -1;
    }

    /* Change gear setpoints to reflect actual percentage sent to motors after adjusting for min move percentage */
    public void adjustSetpointFeedForward() {
        this.topGearSetpoint = this.topGearSetpoint * (1 - MIN_GEAR_MOVE_PERCENT) + MIN_GEAR_MOVE_PERCENT;
        this.botGearSetpoint = this.botGearSetpoint * (1 - MIN_GEAR_MOVE_PERCENT) + MIN_GEAR_MOVE_PERCENT;
    }

    /**
     * @brief Sets the motor speeds of a wheel module at the motor controller level
     *
     * @param topPercent: Percent of max speed to set top gear as
     * @param botPercent: Percent of max speed to set bottom gear as
     */
    public void setMotorSpeed(double topPercent, double botPercent) {

    }

    /**
     * @brief Uses top and bottom gear setpoints to find velocity and angular velocity
     */
    public void findModuleSpeeds() {

        this.angVelSetpoint = (this.topGearSetpoint + this.botGearSetpoint) / 2;
        this.velSetpoint = (-this.topGearSetpoint + this.botGearSetpoint) / 2;
    }

    /**
     * @brief Uses velocity and angular velocity setpoints to find top and bottom gear velocity setpoints
     */
    public void findGearSpeeds() {

        this.topGearSetpoint = this.angVelSetpoint + this.velSetpoint;
        this.botGearSetpoint = this.angVelSetpoint - this.velSetpoint;
    }

    /**
     * @brief Uses difference between robot angle setpoint and current robot angle to find module angular velocity setpoing
     */
    public void findAngVelSetpoint() {
        double angDifRad = TeensySerialManager.read("C") - angSetpoint;
        this.angVelSetpoint = (1 - MIN_ANG_VEL_PERCENT) * Math.pow(angDifRad / MAX_ANG_VEL_ANGLE, 2) + MIN_ANG_VEL_PERCENT;
        this.angVelSetpoint = Math.min(1, this.angVelSetpoint);
        this.angVelSetpoint *= Math.signum(angDifRad);
    }

    /**
     * @brief Gets default rotation sign multiplier in x direction
     */
    public int getRotXDefault() {
        return rotXDefault;
    }

    /**
     * @brief Gets default rotation sign multiplier in y direction
     */
    public int getRotYDefault() {
        return rotYDefault;
    }

    /**
     * @brief Gets current setpoint of top gear (-1 to 1)
     */
    public double getTopGearSetpoint() {
        return this.topGearSetpoint;
    }

    /**
     * @brief Gets current setpoint of bottom gear (-1 to 1)
     */
    public double getBotGearSetpoint() {
        return this.botGearSetpoint;
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
