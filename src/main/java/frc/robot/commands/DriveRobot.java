// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotContainer;
import frc.robot.Constants;

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
  // make sure can't go negative
  // make it so it is press once and moves up on incrment, 0.2 !
  // more on the inside so switch button !
  // 0.4 !
  
  public void execute() {
    SmartDashboard.putNumber("DriveSpeed", Constants.c_driveSpeed);
    if(RobotContainer.addDriveSpeed.get()){
      Constants.c_driveSpeed = Constants.c_driveSpeed + 0.2;
      SmartDashboard.putNumber("DriveSpeed", Constants.c_driveSpeed);
      if(Constants.c_driveSpeed >= 2){
        Constants.c_driveSpeed = 2;
      }
    }
    if(RobotContainer.subtractDriveSpeed.get()){
      Constants.c_driveSpeed = Constants.c_driveSpeed - 0.2;
      SmartDashboard.putNumber("DriveSpeed", Constants.c_driveSpeed);
      if(Constants.c_driveSpeed <= 0.4){
        Constants.c_driveSpeed = 0.4;
      }
    }

    SmartDashboard.putNumber("TurnSpeed", Constants.c_turnSpeed);
    if(RobotContainer.addTurnSpeed.get()){
      Constants.c_turnSpeed = Constants.c_turnSpeed + 0.2;
      SmartDashboard.putNumber("TurnSpeed", Constants.c_turnSpeed);
      if(Constants.c_turnSpeed >= 2){
        Constants.c_turnSpeed = 2;
      }
    }
    if(RobotContainer.subtractTurnSpeed.get()){
      Constants.c_turnSpeed = Constants.c_turnSpeed - 0.2;
      SmartDashboard.putNumber("TurnSpeed", Constants.c_turnSpeed);
      if(Constants.c_turnSpeed <= 0.4){
        Constants.c_turnSpeed = 0.4;
      }
    }

    //getx - along the x axis
    //gety - along the y axis
    //getz - along the z axis
    //if the the dirrection are revrsed add a negative here
    double joystickXInput = -RobotContainer.joystickMain.getX()*Constants.c_driveSpeed;
    double joystickYInput = -RobotContainer.joystickMain.getY()*Constants.c_driveSpeed;
    double joystickZInput = RobotContainer.joystickMain.getZ()*Constants.c_turnSpeed;
    double deadzone = 0.2;
    double turnDeadzone = 0.25;

    if (Math.abs(RobotContainer.joystickMain.getX()) < deadzone) {
      joystickXInput = 0;
    } else if (Math.abs(RobotContainer.joystickMain.getY()) < deadzone) {
      joystickYInput = 0;
    } else if (Math.abs(RobotContainer.joystickMain.getZ()) < turnDeadzone) {
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
