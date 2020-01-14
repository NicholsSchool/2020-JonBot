/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.util.TalonFactory;

public class DriveTrain extends SubsystemBase {

  private WPI_TalonSRX lFMaster;
  private WPI_TalonSRX lFSlave;

  private WPI_TalonSRX lBMaster;
  private WPI_TalonSRX lBSLave;

  private WPI_TalonSRX rFMaster;
  private WPI_TalonSRX rFSLave;

  private WPI_TalonSRX rBMaster;
  private WPI_TalonSRX rBSlave;

  private DifferentialDrive drive;

  public DriveTrain() {

    lFMaster = TalonFactory.createDefaultTalon(RobotMap.LEFT_FRONT_MASTER_ID);
    lFSlave = TalonFactory.createPermanentSlaveTalon(RobotMap.LEFT_FRONT_SLAVE_ID,RobotMap.LEFT_FRONT_MASTER_ID);

    lBMaster = TalonFactory.createDefaultTalon(RobotMap.LEFT_BACK_MASTER_ID);
    lBSLave = TalonFactory.createPermanentSlaveTalon(RobotMap.LEFT_BACK_SLAVE_ID,RobotMap.LEFT_FRONT_MASTER_ID);

    rFMaster = TalonFactory.createDefaultTalon(RobotMap.RIGHT_FRONT_MASTER_ID);
    rFSLave = TalonFactory.createPermanentSlaveTalon(RobotMap.RIGHT_FRONT_SLAVE_ID,RobotMap.RIGHT_FRONT_MASTER_ID);

    rBMaster = TalonFactory.createDefaultTalon(RobotMap.RIGHT_BACK_MASTER_ID);
    rBSlave = TalonFactory.createPermanentSlaveTalon(RobotMap.RIGHT_BACK_SLAVE_ID,RobotMap.RIGHT_BACK_MASTER_ID);

    lFSlave.set(ControlMode.Follower, RobotMap.LEFT_FRONT_MASTER_ID);

    lBSLave.set(ControlMode.Follower, RobotMap.LEFT_BACK_MASTER_ID);

    rFSLave.set(ControlMode.Follower, RobotMap.RIGHT_FRONT_MASTER_ID);

    rBSlave.set(ControlMode.Follower, RobotMap.RIGHT_BACK_MASTER_ID);

    drive = new DifferentialDrive(new SpeedControllerGroup(lFMaster, lBMaster),
        new SpeedControllerGroup(rFMaster, rBMaster));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void move(double leftSpeed, double rightSpeed)
  {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
}