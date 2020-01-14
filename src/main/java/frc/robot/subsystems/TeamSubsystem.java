package frc.robot.subsystems;

public abstract class TeamSubsystem {

    public TeamSubsystem()
    {

    }

    public abstract <T extends TeamSubsystem> T getInstance();


}