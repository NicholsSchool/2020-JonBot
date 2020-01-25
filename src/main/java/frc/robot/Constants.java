/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double DRIVE_F = 0.5;
    public static final double DRIVE_P = 0.5;

    public static final double DRIVE_SENSOR_COEFF = 2.0;

    public static final int MOTION_CRUISE_VEL = 1200;
    public static final int MOTION_ACCEL = MOTION_CRUISE_VEL;

    public static final int DRIVE_BASE_DIAMETER = 0;

    public static final int TURN_MARGIN_OF_ERROR = 5;
}
