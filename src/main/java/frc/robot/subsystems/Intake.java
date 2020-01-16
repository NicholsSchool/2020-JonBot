package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;


public class Intake extends SubsystemBase{
    WPI_TalonSRX topIntake;
    WPI_TalonSRX bottomIntake;
    

    public Intake() {
        topIntake = new WPI_TalonSRX(RobotMap.TOP_INTAKE);
        bottomIntake = new WPI_TalonSRX(RobotMap.BOTTOM_INTAKE);
        bottomIntake.setInverted(true);
        topIntake.configOpenloopRamp(Constants.RAMP_UP);
        bottomIntake.configOpenloopRamp(Constants.RAMP_UP);
    }

    private void move(double speed) {
        topIntake.set(speed);
        bottomIntake.set(speed);
    }

    public void intakeMove() {
        move(Constants.INTAKE_SPEED);
    }

    public void stop(){
        topIntake.stopMotor();
        bottomIntake.stopMotor();
    }

}