/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class BangBangTurn extends CommandBase {

  public double speed;
  public double desiredAngle;

  /**
   * Creates a new BangBangTurn.
   */
  public BangBangTurn(double angle, double turnSpeed) {

    // Use addRequirements() here to declare subsystem dependencies.

    speed = turnSpeed;
    desiredAngle = angle;

    addRequirements(RobotContainer.driveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    System.out.println("Initialized!");

    RobotContainer.navx.reset();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    System.out.println("I am turning!");

    if (desiredAngle > 0) {

      RobotContainer.driveTrain.move(speed, -speed);

    } else {

      RobotContainer.driveTrain.move(-speed, speed);

    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    System.out.println("Stopped!");

    RobotContainer.driveTrain.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    double angleAt = RobotContainer.navx.getAngle();
    
    return (angleAt < desiredAngle + 5 && angleAt > desiredAngle - 5);

  }
}
