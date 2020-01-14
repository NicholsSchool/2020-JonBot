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
  
  public WPI_TalonSRX lFMaster;
  public WPI_TalonSRX lBMaster;
  public WPI_TalonSRX rFMaster;
  public WPI_TalonSRX rBMaster;

  public WPI_TalonSRX lFSlave;
  public WPI_TalonSRX lBSlave;
  public WPI_TalonSRX rFSlave;
  public WPI_TalonSRX rBSlave;
  public DifferentialDrive drive;
  
  public DriveTrain() {
    lFMaster = new WPI_TalonSRX(RobotMap.Left_Front_Master_ID);
    lBMaster = new WPI_TalonSRX(RobotMap.Left_Back_Master_ID);
    rFMaster = new WPI_TalonSRX(RobotMap.Right_Front_Master_ID);
    rBMaster = new WPI_TalonSRX(RobotMap.Right_Back_Master_ID);

    lFSlave = new WPI_TalonSRX(RobotMap.Left_Front_Slave_ID);
    lBSlave = new WPI_TalonSRX(RobotMap.Left_Back_Slave_ID);
    rFSlave = new WPI_TalonSRX(RobotMap.Right_Front_Slave_ID);
    rBSlave = new WPI_TalonSRX(RobotMap.Right_Back_Slave_ID);



    lFSlave.set(ControlMode.Follower, RobotMap.Left_Front_Master_ID);
    lBSlave.set(ControlMode.Follower, RobotMap.Left_Back_Master_ID);
    rFSlave.set(ControlMode.Follower, RobotMap.Right_Front_Master_ID);
    rBSlave.set(ControlMode.Follower, RobotMap.Right_Back_Master_ID);

    drive = new DifferentialDrive(new SpeedControllerGroup(lFMaster, lBMaster), new SpeedControllerGroup(rFMaster, rBMaster));
    }

    public void move(double leftSpeed, double rightSpeed){
      drive.tankDrive(leftSpeed, rightSpeed);
    }  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
