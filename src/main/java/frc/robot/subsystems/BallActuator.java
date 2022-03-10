// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Servo;

public class BallActuator extends SubsystemBase {
  private Servo actuator = new Servo(Constants.c_ballActuator);
  public Servo ballServo = new Servo(Constants.c_ballServo);

  /** Creates a new BallActuator. */
  public BallActuator() {
    actuator.setBounds(2.0, 1.8, 1.5, 1.2, 1.0);
  }

  public void moveActuator(double speed){
    actuator.setSpeed(speed);
  }

  public void changeAngle(double angle){
    ballServo.setAngle(angle);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
