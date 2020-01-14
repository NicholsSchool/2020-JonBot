package frc.robot.subsystems;

public class TestSubsystem extends TeamSubsystem{

    @Override
    public TeamSubsystem getInstance() {
        return new TestSubsystem();
    }


}