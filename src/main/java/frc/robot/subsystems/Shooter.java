/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.util.TalonFactory;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  private WPI_TalonSRX shooterTalon;

  public Shooter() {
    shooterTalon = TalonFactory.createDefaultTalon(RobotMap.SHOOTER);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  private void move(double speed) {
    shooterTalon.set(speed);
  }
}
