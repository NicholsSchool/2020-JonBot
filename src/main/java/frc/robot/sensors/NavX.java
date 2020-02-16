package frc.robot.sensors;

import com.kauailabs.navx.frc.AHRS;

public class NavX {

    private AHRS navX;
    private double orientationZero;

    public NavX(AHRS ahrs) {
        this.navX = ahrs;
    }

    public double getAngle() {
        double angle = navX.getYaw() - orientationZero;
        return wrap(angle);
    }

    private double wrap(double angle) {
        if(angle < -180) {
            return angle + 360;
        }
        if(angle > 180) {
            return angle - 360;
        }
        return angle;
    }

    public double getHeading()
    {
        return navX.getYaw();
    }

    public boolean atAngle(double angle) {
        return (getAngle() < angle + 5 && getAngle() > angle - 5);
    }

    public void reset() {
        // navX.reset();
        orientationZero = navX.getAngle();
    }

}