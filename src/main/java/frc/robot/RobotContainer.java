/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.util.JoystickController;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public static DriveTrain driveTrain;
  public static Intake intake;
  public static Queuer queuer;
  public static Shooter shooter;
  public static Dart dart;

  public static JoystickController j0;
  public static JoystickController j1;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings

    driveTrain = new DriveTrain();
    intake = new Intake();
    shooter = new Shooter();
    queuer = new Queuer();
    dart = new Dart();
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    j0 = new JoystickController(0);
    j1 = new JoystickController(1);

  //  driveTrain.setDefaultCommand(new Drive());
   
    dart.setDefaultCommand(new RunCommand(() -> dart.move(j0.getY()), dart));
    j0.b12.whileHeld(new IntakeBall().alongWith(new Queue()));
    j0.b7.whenPressed(new Queue().withTimeout(0.05));
    j0.b8.whileHeld(new IntakeBall()); 
    j0.b3.whileHeld(new Queue());
    j0.b5.whileHeld(new Dequeue());
    j0.b9.whileHeld(new ReverseShooter());
    j0.b1.whileHeld(new Shoot());
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
