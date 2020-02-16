/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

  private WPI_TalonSRX lFMaster, lFSlave, lBMaster, lBSlave, 
                        rFMaster, rFSlave, rBMaster, rBSlave;
                        
  private SpeedControllerGroup leftMotors, rightMotors;
  private DifferentialDrive drive;

  private final DifferentialDriveOdometry m_odometry;
  public DriveTrain() {
    
    lFMaster = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MASTER_ID);
    lFSlave = new WPI_TalonSRX(RobotMap.LEFT_FRONT_SLAVE_ID);

    lBMaster = new WPI_TalonSRX(RobotMap.LEFT_BACK_MASTER_ID);
    lBSlave = new WPI_TalonSRX(RobotMap.LEFT_BACK_SLAVE_ID);

    rFMaster = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_MASTER_ID);
    rFSlave = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_SLAVE_ID);

    rBMaster = new WPI_TalonSRX(RobotMap.RIGHT_BACK_MASTER_ID);
    rBSlave = new WPI_TalonSRX(RobotMap.RIGHT_BACK_SLAVE_ID);

    lFMaster.configFactoryDefault();
    lBMaster.configFactoryDefault();
    rFMaster.configFactoryDefault();
    rBMaster.configFactoryDefault();

    lFSlave.configFactoryDefault();
    lBSlave.configFactoryDefault();
    rFSlave.configFactoryDefault();
    rBSlave.configFactoryDefault();

    lFMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    rFMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

    lFMaster.setSelectedSensorPosition(0);
    rFMaster.setSelectedSensorPosition(0);

    rFMaster.setSensorPhase(true);

    drive = new DifferentialDrive(leftMotors = new SpeedControllerGroup(lFMaster, lBMaster), 
                                  rightMotors = new SpeedControllerGroup(rFMaster, rBMaster));
    m_odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(RobotContainer.navX.getHeading()));
  }

  public void move(double leftSpeed, double rightSpeed)
  {
  //  System.out.println("LSpeed: " + leftSpeed);
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  /**
   * Returns the currently-estimated pose of the robot.
   *
   * @return The pose.
   */
  public Pose2d getPose() {
    return m_odometry.getPoseMeters();
  }

  /**
   * Returns the current wheel speeds of the robot.
   *
   * @return The current wheel speeds.
   */
  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    return new DifferentialDriveWheelSpeeds(lFMaster.getSelectedSensorVelocity() * (1 / Constants.LEFT_TICKS_PER_METER), rFMaster.getSelectedSensorVelocity() * (1 / Constants.RIGHT_TICKS_PER_METER));
  }

  /**
   * Controls the left and right sides of the drive directly with voltages.
   *
   * @param leftVolts  the commanded left output
   * @param rightVolts the commanded right output
   */
  public void tankDriveVolts(double leftVolts, double rightVolts) {
    SmartDashboard.putNumber("leftVolts", leftVolts);
    SmartDashboard.putNumber("rightVolts", rightVolts);

    leftMotors.setVoltage(leftVolts);
    rightMotors.setVoltage(-rightVolts);
    drive.feed();
  }


  public void stop()
  {
    drive.stopMotor();
  }

  public void resetEncoders()
  {
    lFMaster.setSelectedSensorPosition(0);
    rFMaster.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_odometry.update(Rotation2d.fromDegrees(RobotContainer.navX.getHeading()),
     lFMaster.getSelectedSensorPosition() * (1 / Constants.LEFT_TICKS_PER_METER) , 
     rFMaster.getSelectedSensorPosition() * (1 / Constants.RIGHT_TICKS_PER_METER) );
    SmartDashboard.putNumber("NAVX HEADING: ", RobotContainer.navX.getHeading());


    SmartDashboard.putNumber("Left Front Encoder", lFMaster.getSelectedSensorPosition());
    SmartDashboard.putNumber("Right Front Encoder", rFMaster.getSelectedSensorPosition());
  }
}
