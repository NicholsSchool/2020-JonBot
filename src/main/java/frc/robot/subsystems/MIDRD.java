/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

public class MIDRD extends SubsystemBase {

    private WPI_TalonSRX MIDRD;

    public MIDRD() {
        MIDRD = new WPI_TalonSRX(RobotMap.MIDRD_ID);
    }
}
