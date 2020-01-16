package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.util.TalonFactory;

public class Dart {

    private WPI_TalonSRX dart;

    public Dart(){
        dart = TalonFactory.createDefaultTalon(21);
    }

    public void move(double speed){
        dart.set(speed);
    }

    public void stopMotor(){
        dart.stopMotor();
    }


}