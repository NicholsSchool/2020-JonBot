/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.autonomous.BangBangTurn;
import frc.robot.commands.Drive;
import frc.robot.commands.Shoot;
import frc.robot.sensors.NavX;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Queuer;
import frc.robot.subsystems.Shooter;
import frc.robot.util.JoystickController;

import edu.wpi.first.wpilibj.SPI;

public class RobotContainer {

  public static NavX navx;

  public static DriveTrain driveTrain;
  public static Shooter shooter;
  public static Intake intake;

  public static JoystickController j0;
  public static JoystickController j1;

  public RobotContainer() {

    // Configure the button bindings

    navx = new NavX(new AHRS (SPI.Port.kMXP));
    driveTrain = new DriveTrain();
    shooter = new Shooter();
    
    configureButtonBindings();
    
  }

  private void configureButtonBindings() {

    j0 = new JoystickController(0);
    j1 = new JoystickController(1);

    j0.b1.whenPressed(new BangBangTurn(90 , 0.40));

   // j0.b1.whileHeld(new Shoot());

     driveTrain.setDefaultCommand(new Drive());
  }

  public Command getAutonomousCommand() {

    return null;

  }
}
