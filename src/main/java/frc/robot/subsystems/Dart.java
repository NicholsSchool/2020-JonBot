
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;
import frc.robot.RobotMap;

public class Dart extends SubsystemBase {
    private WPI_TalonSRX dart;

  public Dart() {
    dart = new WPI_TalonSRX(RobotMap.DART);
    dart.configOpenloopRamp(Constants.DART_RAMP_RATE);
  }
  public void move(double speed) {
    dart.set(speed);
  
  }
  public void stop(){
    dart.stopMotor();
  }


  @Override
  public void periodic() {
  }
}
