/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class MotionMagic extends CommandBase {
  /**
   * Creates a new MotionMagic.
   */
  public MotionMagic() {
    addRequirements(RobotContainer.driveTrain);
  }

  @Override
  public void initialize() {
 
  }

  @Override
  public void execute() {

    System.out.println("Running Motion Magic");
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveTrain.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
