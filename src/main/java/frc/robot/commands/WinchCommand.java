// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class WinchCommand extends CommandBase {
  /** Creates a new WinchCommand. */
  public WinchCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_winch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_winch.winchTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1);
    RobotContainer.m_winch.winchTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double encoderValue = RobotContainer.m_winch.winchTalon.getSelectedSensorPosition(0);

;
    if(RobotContainer.downWinchButton.get() && encoderValue < Constants.maxWinchPos){
      RobotContainer.m_winch.move(0.5);
      SmartDashboard.putBoolean("winch moving", true);
    }
    else if(RobotContainer.upWinchButton.get() && encoderValue > Constants.minWinchPos){
      RobotContainer.m_winch.move(-0.5);
      SmartDashboard.putBoolean("winch moving", true);
    }
    else{
      SmartDashboard.putBoolean("winch moving",false);
      RobotContainer.m_winch.move(0);
    }
    
    SmartDashboard.putNumber("winchEncoder",encoderValue);
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
