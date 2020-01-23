/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.fasterxml.jackson.databind.cfg.MutableConfigOverride;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {

 private WPI_TalonSRX shooter;

  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    shooter = new WPI_TalonSRX(RobotMap.SHOOTER_ID);
  }

  public void shoot()
  {
    move(Constants.SHOOTER_SPEED);
  }

  private void move(double speed)
  {
    shooter.set(speed);
  }

  public void stop()
  {
    shooter.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
