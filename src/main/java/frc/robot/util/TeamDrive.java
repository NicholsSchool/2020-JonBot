package frc.robot.util;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TeamDrive extends DifferentialDrive {

    private WPI_TalonSRX[] talons;

    public TeamDrive(SpeedControllerGroup leftSide, SpeedControllerGroup rightSide){
        super(leftSide, rightSide);
        
    }

    public TeamDrive(WPI_TalonSRX leftFront, WPI_TalonSRX leftBack, WPI_TalonSRX rightFront, WPI_TalonSRX rightBack){
        this(new SpeedControllerGroup(leftFront, leftBack), new SpeedControllerGroup(rightFront, rightBack));
        talons = new WPI_TalonSRX[4];
        talons[0] = leftFront;
        talons[1] = leftBack;
        talons[2] = rightFront;
        talons[3] = rightBack;
    }

    public void configPeakCurrentLimit(int amps)
    {
        for(WPI_TalonSRX t : talons)
            t.configPeakCurrentLimit(amps);
    }

    public double getCurrent()
    {
        double sum = 0;

        for(WPI_TalonSRX t : talons)
            sum += t.getStatorCurrent(); //Maybe? There is another method we could use.
        
        return sum;
    }


}