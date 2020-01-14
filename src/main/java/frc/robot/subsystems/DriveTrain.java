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
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

  private WPI_TalonSRX lFMaster;
  private WPI_TalonSRX lFSlave;
  private WPI_TalonSRX lBMaster;
  public WPI_TalonSRX lBSlave;
  private WPI_TalonSRX rFMaster;
  private WPI_TalonSRX rFSlave;
  private WPI_TalonSRX rBMaster;
  private WPI_TalonSRX rBSlave;
  private DifferentialDrive drive;
 
 
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
      lFMaster = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MASTER_ID);
      lFSlave = new WPI_TalonSRX(RobotMap.LEFT_FRONT_SLAVE_ID);
      lBMaster = new WPI_TalonSRX(RobotMap.LEFT_BACK_MASTER_ID);
      lBSlave = new WPI_TalonSRX(RobotMap.LEFT_BACK_SLAVE_ID);
      rFMaster = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_MASTER_ID);
      rFSlave = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_SLAVE_ID);
      rBMaster = new WPI_TalonSRX(RobotMap.RIGHT_BACK_MASTER_ID);
      rBSlave = new WPI_TalonSRX(RobotMap.RIGHT_BACK_SLAVE_ID);

      lFSlave.set(ControlMode.Follower, RobotMap.LEFT_FRONT_MASTER_ID);
      lBSlave.set(ControlMode.Follower, RobotMap.LEFT_BACK_MASTER_ID);
      rFSlave.set(ControlMode.Follower, RobotMap.RIGHT_FRONT_MASTER_ID);
      rBSlave.set(ControlMode.Follower, RobotMap.RIGHT_BACK_MASTER_ID);
      drive = new DifferentialDrive (new SpeedControllerGroup(lFMaster, lBMaster), new SpeedControllerGroup( rFMaster,rBMaster));
      
  }
  public void move( double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
