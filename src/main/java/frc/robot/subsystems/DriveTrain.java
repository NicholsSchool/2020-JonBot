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
    lBMaster = new WPI_TalonSRX(RobotMap.LEFT_BACK_MASTER_ID);
    lFMaster = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MASTER_ID);
    rFMaster = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_MASTER_ID);
    rBMaster = new WPI_TalonSRX(RobotMap.RIGHT_BACK_MASTER_ID);

    lFMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    rFMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    rBMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    lBMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
   
    lFMaster.config_kF(0, Constants.LEFT_FRONT_MASTER_F, Constants.CONFIG_TIMEOUT);
    lFMaster.config_kP(0, Constants.LEFT_FRONT_MASTER_P, Constants.CONFIG_TIMEOUT);
    lFMaster.config_kI(0, Constants.LEFT_FRONT_MASTER_I, Constants.CONFIG_TIMEOUT);
    lFMaster.config_kD(0, Constants.LEFT_FRONT_MASTER_D, Constants.CONFIG_TIMEOUT);

    lBMaster.config_kF(0, Constants.LEFT_BACK_MASTER_F, Constants.CONFIG_TIMEOUT);
    lBMaster.config_kP(0, Constants.LEFT_BACK_MASTER_P, Constants.CONFIG_TIMEOUT);
    lBMaster.config_kI(0, Constants.LEFT_BACK_MASTER_I, Constants.CONFIG_TIMEOUT);
    lBMaster.config_kD(0, Constants.LEFT_BACK_MASTER_D, Constants.CONFIG_TIMEOUT);

    rFMaster.config_kF(0, Constants.RIGHT_FRONT_MASTER_F, Constants.CONFIG_TIMEOUT);
    rFMaster.config_kP(0, Constants.RIGHT_FRONT_MASTER_P, Constants.CONFIG_TIMEOUT);
    rFMaster.config_kI(0, Constants.RIGHT_FRONT_MASTER_I, Constants.CONFIG_TIMEOUT);
    rFMaster.config_kD(0, Constants.RIGHT_FRONT_MASTER_D, Constants.CONFIG_TIMEOUT);

    rBMaster.config_kF(0, Constants.RIGHT_BACK_MASTER_F, Constants.CONFIG_TIMEOUT);
    rBMaster.config_kP(0, Constants.RIGHT_BACK_MASTER_P, Constants.CONFIG_TIMEOUT);
    rBMaster.config_kI(0, Constants.RIGHT_BACK_MASTER_I, Constants.CONFIG_TIMEOUT);
    rBMaster.config_kD(0, Constants.RIGHT_BACK_MASTER_D, Constants.CONFIG_TIMEOUT);

    lFMaster = TalonFactory.createDefaultTalon(RobotMap.LEFT_FRONT_MASTER_ID);
    lFSlave = TalonFactory.createPermanentSlaveTalon(RobotMap.LEFT_FRONT_SLAVE_ID, RobotMap.LEFT_FRONT_MASTER_ID);

    lBMaster = TalonFactory.createDefaultTalon(RobotMap.LEFT_BACK_MASTER_ID);
    lBSLave = TalonFactory.createPermanentSlaveTalon(RobotMap.LEFT_BACK_SLAVE_ID, RobotMap.LEFT_BACK_MASTER_ID);

    rFMaster = TalonFactory.createDefaultTalon(RobotMap.RIGHT_FRONT_MASTER_ID);
    rFSLave = TalonFactory.createPermanentSlaveTalon(RobotMap.RIGHT_FRONT_SLAVE_ID, RobotMap.RIGHT_FRONT_MASTER_ID);

    rBMaster = TalonFactory.createDefaultTalon(RobotMap.RIGHT_BACK_MASTER_ID);
    rBSlave = TalonFactory.createPermanentSlaveTalon(RobotMap.RIGHT_BACK_SLAVE_ID, RobotMap.RIGHT_BACK_MASTER_ID);

    lFSlave.set(ControlMode.Follower, RobotMap.LEFT_FRONT_MASTER_ID);

    lBSLave.set(ControlMode.Follower, RobotMap.LEFT_BACK_MASTER_ID);

    rFSLave.set(ControlMode.Follower, RobotMap.RIGHT_FRONT_MASTER_ID);

    rBSlave.set(ControlMode.Follower, RobotMap.RIGHT_BACK_MASTER_ID);

    lFMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Constants.CONFIG_TIMEOUT);

    lBMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Constants.CONFIG_TIMEOUT);

    rFMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Constants.CONFIG_TIMEOUT);

    rBMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Constants.CONFIG_TIMEOUT);

    drive = new DifferentialDrive(new SpeedControllerGroup(lFMaster, lBMaster),
        new SpeedControllerGroup(rFMaster, rBMaster));
  }

  public void encoderTest() {
    SmartDashboard.putNumber("lFEncoder", lFMaster.getSelectedSensorPosition());

    SmartDashboard.putNumber("rFEncoder", rFMaster.getSelectedSensorPosition());

    SmartDashboard.putNumber("rBEncoder", rBMaster.getSelectedSensorPosition());

    SmartDashboard.putNumber("lBEncoder", lBMaster.getSelectedSensorPosition());
  }

  @Override
  public void periodic() {

    encoderTest();

  }
  public void configMotionMagic(int velocity, int acceleration){
    lFMaster.configMotionAcceleration(acceleration);
    lFMaster.configMotionCruiseVelocity(velocity);
    lFMaster.setSelectedSensorPosition(0);

    rFMaster.configMotionAcceleration(acceleration);
    rFMaster.configMotionCruiseVelocity(velocity);
    rFMaster.setSelectedSensorPosition(0);

    rBMaster.configMotionAcceleration(acceleration);
    rBMaster.configMotionCruiseVelocity(velocity);
    rBMaster.setSelectedSensorPosition(0);

    lBMaster.configMotionAcceleration(acceleration);
    lBMaster.configMotionCruiseVelocity(velocity);
    lBMaster.setSelectedSensorPosition(0);

    velocity = 2500;
    acceleration = 1000;
  }

  public void move(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }

public void stop() {
  lFMaster.stopMotor();
  rFMaster.stopMotor();
  rBMaster.stopMotor();
  lBMaster.stopMotor();
}
public void startMotionMagic(int position){
  lBMaster.set(ControlMode.MotionMagic, position);
  lFMaster.set(ControlMode.MotionMagic, position);
  rBMaster.set(ControlMode.MotionMagic, position);
  rFMaster.set(ControlMode.MotionMagic, position);
}
}