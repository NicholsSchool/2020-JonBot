
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;

public class Dart extends CommandBase {

  private WPI_TalonSRX dart;

  public Dart() {

    dart = new WPI_TalonSRX(RobotMap.DART);

  }

 
  @Override
  public void initialize() {
  }


  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  public void move() {

    dart.set(stinkyPoopy);

   
  }
}
