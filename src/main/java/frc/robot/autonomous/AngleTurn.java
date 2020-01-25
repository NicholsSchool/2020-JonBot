package frc.robot.autonomous;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;



public class AngleTurn extends CommandBase
{
    public double speed;
    public double desiredAngle;
    /**
     * The AngleTurn class turns the robot to a desired angle 
     * using the NavX sensor, using the DriveTrain.
     * 
     * @param agl - the angle the robot will rotate to
     * @param spd 
    **/
    public AngleTurn(double agl, double spd)
    {
       agl = desiredAngle;
       spd = speed;
        
        addRequirements(RobotContainer.driveTrain);
    }

    @Override
    public void initialize()
    {
        RobotContainer.navX.reset();
    }

  
    @Override
    public void execute() 
    {
        System.out.println("Turning");
        if(desiredAngle > 0)
            RobotContainer.driveTrain.move(-speed,speed );
        
        else{
            RobotContainer.driveTrain.move(speed, -speed);
        }
           
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished()
    {
        double currentAngle = RobotContainer.navX.getAngle();
        return (currentAngle < desiredAngle + 5 && currentAngle > desiredAngle - 5);
    }

   
}