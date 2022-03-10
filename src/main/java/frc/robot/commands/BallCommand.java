// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    SmartDashboard.putNumber("Servo Angle", RobotContainer.m_ballActuator.ballServo.getAngle());
    SmartDashboard.putNumber("Servo", RobotContainer.m_ballActuator.ballServo.getPosition());
    //need to change so toggle
    //Ball Actuator
    if(RobotContainer.upBallAcutatorButton.get()){
      RobotContainer.m_ballActuator.moveActuator(2);
    }
    else if(RobotContainer.downBallActuatorButton.get()){
      RobotContainer.m_ballActuator.moveActuator(-2);
    }
    //Ball Servo
    if(RobotContainer.upBallServoButton.get()){
    RobotContainer.m_ballActuator.changeAngle(0);
    }
    else if(RobotContainer.downBallServoButton.get()){
    RobotContainer.m_ballActuator.changeAngle(180);
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
