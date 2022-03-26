// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class Auto extends CommandBase {
  public Auto() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_ballActuatorServo, RobotContainer.m_driveTrain);
  }

  Timer autoTime = new Timer();
  public Boolean mode = true;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    autoTime.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    autoTime.start();
   if (mode) {
     while (autoTime.get() <= 9.1) {
        RobotContainer.m_ballActuatorServo.moveActuatorInput(Constants.c_outPostion);
        if (RobotContainer.m_ballActuatorServo.getAngle() < 255) {
          RobotContainer.m_ballActuatorServo.changeAngleInput(1);
        }
      }
      while (autoTime.get() <= 10.6) {
        RobotContainer.m_driveTrain.driveCartesian(-0.5, 0, 0);
      }
    } else {
      //Taxi only mode
      while (autoTime.get() <= 1.6) {
        RobotContainer.m_driveTrain.driveCartesian(-0.5, 0, 0);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_ballActuatorServo.moveActuatorInput(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
