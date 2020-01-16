/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.util.TalonFactory;

public class Queuer extends SubsystemBase {

  private WPI_TalonSRX topQueuerTalon;
  private WPI_TalonSRX bottomQueuerTalon;

  /**
   * Creates a new Queuer.
   */
  public Queuer() {

    topQueuerTalon = new WPI_TalonSRX(RobotMap.TOP_QUEUER);
    bottomQueuerTalon = new WPI_TalonSRX(RobotMap.BOTTOM_QUEUER);

    topQueuerTalon.setInverted(true);
    bottomQueuerTalon.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  private void move(double speed) {

    topQueuerTalon.set(speed);
    bottomQueuerTalon.set(speed);

  }

  public void queue() {
    move(Constants.QUEUER_SPEED);
  }

  public void stop() {

    topQueuerTalon.stopMotor();
    bottomQueuerTalon.stopMotor();
    
  }

}
