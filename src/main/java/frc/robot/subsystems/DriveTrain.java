/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
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
    lFSlave = TalonFactory.createPermanentSlaveTalon(RobotMap.LEFT_FRONT_SLAVE_ID, RobotMap.LEFT_FRONT_MASTER_ID);

    lBMaster = TalonFactory.createDefaultTalon(RobotMap.LEFT_BACK_MASTER_ID);
    lBSLave = TalonFactory.createPermanentSlaveTalon(RobotMap.LEFT_BACK_SLAVE_ID, RobotMap.LEFT_BACK_SLAVE_ID);

    rFMaster = TalonFactory.createDefaultTalon(RobotMap.RIGHT_FRONT_MASTER_ID);
    rFSLave = TalonFactory.createPermanentSlaveTalon(RobotMap.RIGHT_FRONT_SLAVE_ID, RobotMap.RIGHT_FRONT_SLAVE_ID);

    rBMaster = TalonFactory.createDefaultTalon(RobotMap.RIGHT_BACK_MASTER_ID);
    rBSlave = TalonFactory.createPermanentSlaveTalon(RobotMap.RIGHT_BACK_SLAVE_ID, RobotMap.RIGHT_BACK_SLAVE_ID);

    lFMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Constants.CONFIG_TIMEOUT);

    lBMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Constants.CONFIG_TIMEOUT);

    rFMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Constants.CONFIG_TIMEOUT);

    rBMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Constants.CONFIG_TIMEOUT);

    drive = new DifferentialDrive(new SpeedControllerGroup(lFMaster, lBMaster),
        new SpeedControllerGroup(rFMaster, rBMaster));

  }

  public void encoderTest() {
    
    SmartDashboard.putNumber("lFEncoderValue", lFMaster.getSelectedSensorPosition());

    SmartDashboard.putNumber("lBEncoderValue", lBMaster.getSelectedSensorPosition());

    SmartDashboard.putNumber("rFEncoderValue", rFMaster.getSelectedSensorPosition());

    SmartDashboard.putNumber("rBEncoderValue", rBMaster.getSelectedSensorPosition());

  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run

    encoderTest();

  }

  public void move(double leftSpeed, double rightSpeed) {

    drive.tankDrive(leftSpeed, rightSpeed);

  }

  public void stop() {

    RobotContainer.driveTrain.move(0,0);

  }

}