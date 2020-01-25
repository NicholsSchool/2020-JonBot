package frc.robot.autonomous;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;


public class AngleTurn extends CommandBase
{
    public double speed;
    public double desiredAngle;
    /**
     * The AngleTurn class turns the robot to a desired angle 
     * using the NavX sensor, using the DriveTrain.
     * 
     * @param agl - the angle the robot will rotate to
     * @param spd - the speed which the robot will rotate
     */
    public AngleTurn(double agl, double spd)
    {
        
        speed = spd;
        desiredAngle = agl;

        addRequirements(RobotContainer.driveTrain);
    }

    @Override
    public void initialize()
    {
        RobotContainer.navX.reset();
    }

    /**
     * The excecute method determines wether the robot turns
     * to the right or left, depending on which direction 
     * is shorter.
     */
    @Override
    public void execute() 
    {
        System.out.println("Turning");
        if(desiredAngle > 0)
            RobotContainer.driveTrain.sigmoidMove(speed, -speed);    
        
        else
            RobotContainer.driveTrain.sigmoidMove(-speed, speed);
        
    }

    /**
     * This method specifies a range of angles. the DriveTrain
     * stops when the robot is at an angle within the range.
     * The range is necessary becouse otherwise the robot would never 
     * return an angle that is precisely the value the method requires.   
     */
    @Override
    public boolean isFinished()
    {
        double currentAngle = RobotContainer.navX.getAngle();
        return (currentAngle < desiredAngle + 5 && currentAngle > desiredAngle - 5);
    }

    @Override
    public void interrupted()
    {
        end();
    }

    @Override
    public void end() 
    {
        RobotContainer.driveTrain.stop();
    }
}