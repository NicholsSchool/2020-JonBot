/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class MotionMagicTurn extends CommandBase {
    private double target;
    private double start;

    /**
     * Creates a new MotionMagicTurn.
     * 
     * @param angle the desired angle in degrees
     */
    public MotionMagicTurn(double angle) {
        target = angle;

        addRequirements(RobotContainer.driveTrain);
    }

    @Override
    public void initialize() {
        start = RobotContainer.navX.getAngle();
        RobotContainer.driveTrain.resetEncoders();
    }

    @Override
    public void execute() {
        double error = target - (RobotContainer.navX.getAngle() - start);
        System.out.println("Motion magic turn error: " + error);
        // Ticks based on arc length of the circle inscribed in the base of the drive train
        int ticks = (int) (Constants.DRIVE_BASE_DIAMETER * Math.PI * error / 360);

        RobotContainer.driveTrain.motionMagicMove(ticks, -ticks);
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.driveTrain.stop();
    }

    @Override
    public boolean isFinished() {
        double error = target - (RobotContainer.navX.getAngle() - start);

        return Math.abs(error) < Constants.TURN_MARGIN_OF_ERROR;
    }
}
