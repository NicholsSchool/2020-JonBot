/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Drive;
import frc.robot.commands.MotionMagic;
import frc.robot.commands.Queue;
import frc.robot.sensors.NavX;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Queuer;
import frc.robot.util.JoystickController;

public class RobotContainer {
  public  static NavX navX;

  public static DriveTrain driveTrain;

  public static JoystickController b3;

  public static JoystickController b12;

  public static JoystickController j0;
  public static JoystickController j1;
  
  public static Queuer queuer;
  // The robot's subsystems and commands are defined here...


  public RobotContainer() {
    driveTrain = new DriveTrain();
    // Configure the button bindings

    queuer = new Queuer();

    navX = new NavX(new AHRS(SPI.Port.kMXP));
    
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    j0 = new JoystickController(0);
    j1 = new JoystickController(1);

    j0.b3.whileHeld(new Queue());
    j0.b12.whenPressed(new MotionMagic());

    


    
     driveTrain.setDefaultCommand(new Drive());
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
