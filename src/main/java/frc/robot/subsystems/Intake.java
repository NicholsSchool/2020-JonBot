package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;
import frc.robot.util.TalonFactory;

public class Intake {
    WPI_TalonSRX topIntake;
    WPI_TalonSRX bottomIntake;

    public Intake() {
        topIntake = TalonFactory.createDefaultTalon(32);
        bottomIntake = TalonFactory.createDefaultTalon(34);
    }

    private void move(double speed) {
        topIntake.set(speed);
        bottomIntake.set(speed);
    }

    public void intake() {
        move(Constants.INTAKE_SPEED);
    }

    public void stop(){
        topIntake.stopMotor();
        bottomIntake.stopMotor();
    }

}