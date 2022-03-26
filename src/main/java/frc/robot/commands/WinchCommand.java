// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class WinchCommand extends CommandBase {
  /** Creates a new WinchCommand. */
  public WinchCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_winch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Winch
    if(RobotContainer.upWinchButton.get()){
      RobotContainer.m_winch.move(Constants.c_winchSpeedUp);
    }
    else if(RobotContainer.downWinchButton.get()){
      RobotContainer.m_winch.move(Constants.c_winchSpeedDown);
    }
    else{
      RobotContainer.m_winch.move(0);
    }

    //Winch Servo
    if(RobotContainer.winchServoButton.get()){
      RobotContainer.m_winch.changeAngle(Constants.c_lockedAngle);
      SmartDashboard.putBoolean("Servo Lock Engaged", true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
