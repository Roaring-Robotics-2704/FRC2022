// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    if(RobotContainer.upWinchButton.get()){
      RobotContainer.m_winch.move(1);
    }
    else if(RobotContainer.downWinchButton.get()){
      RobotContainer.m_winch.move(-1);
    }
    else{
      RobotContainer.m_winch.move(0);
    }

    if(RobotContainer.winchServoButton.get()){
      RobotContainer.m_winch.changeAngle(90);
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
