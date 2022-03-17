// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BallActuator_Servo;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;


public class Auto extends CommandBase {
  public Auto() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_ballActuator, RobotContainer.m_driveTrain);
  }

  Timer autoTime = new Timer();
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    autoTime.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    autoTime.start();
    while (autoTime.get() <= 9.1) {
        RobotContainer.m_ballActuator.moveActuatorInput(1);
        if (RobotContainer.m_ballActuator.getAngle() < 255) {
          RobotContainer.m_ballActuator.changeAngleInput(1);
        }
    }
    while (autoTime.get() <= 10.6) {
        RobotContainer.m_driveTrain.driveCartesian(-0.5, 0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_ballActuator.moveActuatorInput(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
