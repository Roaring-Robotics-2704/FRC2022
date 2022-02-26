// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BallActuator;

public class BallCommand extends CommandBase {
  /** Creates a new BallCommand. */
  public BallCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_ballActuator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.upBallAcutatorButton.get()){
      RobotContainer.m_ballActuator.move(2);
    }
    else if(RobotContainer.downBallActuatorButton.get()){
      RobotContainer.m_ballActuator.move(-2);
    }
    //else{
    //  RobotContainer.m_ballActuator.move(0);
    //}

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
