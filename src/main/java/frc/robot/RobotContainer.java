/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.util.JoystickController;

public class RobotContainer {

  public static DriveTrain driveTrain; 

  public static JoystickController j0;
  public static JoystickController j1;

  public RobotContainer() {
    driveTrain = new DriveTrain();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    j0 = new JoystickController(0);
    j1 = new JoystickController(1);

    driveTrain.setDefaultCommand(new Drive());

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
