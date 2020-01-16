/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
    private WPI_TalonSRX shooter;
  /**
   * Creates a new ExampleSubsystem.
   */
  public Shooter() {
    shooter = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MASTER_ID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
