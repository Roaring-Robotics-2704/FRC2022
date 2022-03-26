// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class DriveRobot extends CommandBase {
  /** Creates a new DriveRobot. */
  public DriveRobot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {  
  }
  //don't need to put anything in here

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Drive Speed
    //increasing drive speed
    SmartDashboard.putNumber("DriveSpeed", Constants.c_driveSpeed);
    if(RobotContainer.addDriveSpeed.get() || RobotContainer.addDriveSpeedSecondary.get()){
      Constants.c_driveSpeed = Constants.c_driveSpeed + Constants.c_speedIncrementIncrease;
      SmartDashboard.putNumber("DriveSpeed", Constants.c_driveSpeed);
      if(Constants.c_driveSpeed >= Constants.c_upperSpeedLimit){
        Constants.c_driveSpeed = Constants.c_upperSpeedLimit;
      }
    }
    //decreasing drive speed
    if(RobotContainer.subtractDriveSpeed.get() || RobotContainer.subtractDriveSpeedSecondary.get()){
      Constants.c_driveSpeed = Constants.c_driveSpeed + Constants.c_speedIncrementDecrease;
      SmartDashboard.putNumber("DriveSpeed", Constants.c_driveSpeed);
      if(Constants.c_driveSpeed <= Constants.c_lowerSpeedLimit){
        Constants.c_driveSpeed = Constants.c_lowerSpeedLimit;
      }
    }

    //Turning Speed
    //increasing turning speed
    SmartDashboard.putNumber("TurnSpeed", Constants.c_turnSpeed);
    if(RobotContainer.addTurnSpeed.get() || RobotContainer.addTurnSpeedSecondary.get()){
      Constants.c_turnSpeed = Constants.c_turnSpeed + Constants.c_speedIncrementIncrease;
      SmartDashboard.putNumber("TurnSpeed", Constants.c_turnSpeed);
      if(Constants.c_turnSpeed >= Constants.c_upperSpeedLimit){
        Constants.c_turnSpeed = Constants.c_upperSpeedLimit;
      }
    }
    //decreasing turning speed
    if(RobotContainer.subtractTurnSpeed.get() || RobotContainer.subtractTurnSpeedSecondary.get()){
      Constants.c_turnSpeed = Constants.c_turnSpeed + Constants.c_speedIncrementDecrease;
      SmartDashboard.putNumber("TurnSpeed", Constants.c_turnSpeed);
      if(Constants.c_turnSpeed <= Constants.c_lowerSpeedLimit){
        Constants.c_turnSpeed = Constants.c_lowerSpeedLimit;
      }
    }

    //getx - along the x axis
    //gety - along the y axis
    //getz - along the z axis
    //if the the dirrection are revrsed add a negative here
    double joystickXInput = -RobotContainer.joystickMain.getX()*Constants.c_driveSpeed;
    double joystickYInput = -RobotContainer.joystickMain.getY()*Constants.c_driveSpeed;
    double joystickZInput = RobotContainer.joystickMain.getZ()*Constants.c_turnSpeed;
    double deadzone = Constants.c_deadBand;
    double turnDeadzone = Constants.c_turningDeadBand;

    if (Math.abs(RobotContainer.joystickMain.getX()) < deadzone) {
      joystickXInput = 0;
    } 
    else if (Math.abs(RobotContainer.joystickMain.getY()) < deadzone) {
      joystickYInput = 0;
    } 
    else if (Math.abs(RobotContainer.joystickMain.getZ()) < turnDeadzone) {
      joystickZInput = 0;
    }
    
    //call driveCartesion from Drive Train
    //driveCartesian(double movementSpeed, double strafeSpeed, double turningSpeed)
    //movementSpeed - speed along y axis, right is positive
    //strafeSpeed - speed along x axis, forward is positive
    //turningspeed - rotation rate around the z axis, clockwise is positve
    RobotContainer.m_driveTrain.driveCartesian(joystickYInput, joystickXInput, joystickZInput);
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
