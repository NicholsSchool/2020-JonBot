/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {

  public WPI_TalonSRX topIntake, bottomIntake;
  /**
   * Creates a new Intake.
   */
  public Intake() {
    topIntake = new WPI_TalonSRX(RobotMap.TOP_INTAKE_ID);
    bottomIntake = new WPI_TalonSRX(RobotMap.BOTTOM_INTAKE_ID);

    bottomIntake.setInverted(true);
  }
  
  public void intake()
  {
    move(Constants.INTAKE_SPEED);
  }

  private void move(double speed)
  {
    topIntake.set(speed);
    bottomIntake.set(speed);
  }

  public void stop()
  {
    topIntake.stopMotor();
    bottomIntake.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
