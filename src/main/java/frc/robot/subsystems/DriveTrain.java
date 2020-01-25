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
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

    private WPI_TalonSRX lFMaster, lFSlave, lBMaster, lBSlave, rFMaster, rFSlave, rBMaster, rBSlave;

    private DifferentialDrive drive;

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

        lFSlave.set(ControlMode.Follower, RobotMap.LEFT_FRONT_MASTER_ID);
        lBSlave.set(ControlMode.Follower, RobotMap.LEFT_BACK_MASTER_ID);
        rFSlave.set(ControlMode.Follower, RobotMap.RIGHT_FRONT_MASTER_ID);
        rBSlave.set(ControlMode.Follower, RobotMap.RIGHT_BACK_MASTER_ID);

        drive = new DifferentialDrive(new SpeedControllerGroup(lFMaster, lBMaster),
                new SpeedControllerGroup(rFMaster, rBMaster));

        lFMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        lBMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rFMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rBMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

        lFMaster.configSelectedFeedbackCoefficient(Constants.DRIVE_SENSOR_COEFF);
        rFMaster.configSelectedFeedbackCoefficient(Constants.DRIVE_SENSOR_COEFF);

        lFMaster.config_kF(0, Constants.DRIVE_F);
        lBMaster.config_kF(0, Constants.DRIVE_F);
        rFMaster.config_kF(0, Constants.DRIVE_F);
        rBMaster.config_kF(0, Constants.DRIVE_F);

        lFMaster.config_kP(0, Constants.DRIVE_P);
        lBMaster.config_kP(0, Constants.DRIVE_P);
        rFMaster.config_kP(0, Constants.DRIVE_P);
        rBMaster.config_kP(0, Constants.DRIVE_P);

        lFMaster.configMotionAcceleration(Constants.MOTION_ACCEL);
        lBMaster.configMotionAcceleration(Constants.MOTION_ACCEL);
        rFMaster.configMotionAcceleration(Constants.MOTION_ACCEL);
        rBMaster.configMotionAcceleration(Constants.MOTION_ACCEL);

        lFMaster.configMotionCruiseVelocity(Constants.MOTION_CRUISE_VEL);
        lBMaster.configMotionCruiseVelocity(Constants.MOTION_CRUISE_VEL);
        rFMaster.configMotionCruiseVelocity(Constants.MOTION_CRUISE_VEL);
        rBMaster.configMotionCruiseVelocity(Constants.MOTION_CRUISE_VEL);
    }

    public void move(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void motionMagicMove(int lPosition, int rPosition) {
        lFMaster.set(ControlMode.MotionMagic, lPosition);
        lBMaster.set(ControlMode.MotionMagic, lPosition);
        rFMaster.set(ControlMode.MotionMagic, rPosition);
        rBMaster.set(ControlMode.MotionMagic, rPosition);
    }

    public void stop() {
        move(0, 0);
    }

    public void resetEncoders() {
        lFMaster.setSelectedSensorPosition(0);
        lBMaster.setSelectedSensorPosition(0);
        rFMaster.setSelectedSensorPosition(0);
        rBMaster.setSelectedSensorPosition(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("lFMaster Vel", lFMaster.getSelectedSensorVelocity());
        SmartDashboard.putNumber("lBMaster Vel", lBMaster.getSelectedSensorVelocity());
        SmartDashboard.putNumber("rFMaster Vel", rFMaster.getSelectedSensorVelocity());
        SmartDashboard.putNumber("rBMaster Vel", rBMaster.getSelectedSensorVelocity());
    }
}
