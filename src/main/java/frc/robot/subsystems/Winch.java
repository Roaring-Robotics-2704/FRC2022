// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class Winch extends SubsystemBase {
  /** Creates a new Winch. */
  //Declare winch motors
  private WPI_TalonSRX winchTalon = new WPI_TalonSRX(Constants.c_winchTalonMotor);
  private WPI_VictorSPX winchVictor = new WPI_VictorSPX(Constants.c_winchVictorMotor);

  //Declare motorControllerGroup, previosuly known as SpeedControllerGroup
  private MotorControllerGroup winchMotors = new MotorControllerGroup(winchTalon, winchVictor);

  //Declare winch servo
  public Servo winchServo = new Servo(Constants.c_winchServo);
 
  public Winch() {
  }
  //Winch
  public void move(double speed){
      winchMotors.set(speed);
  }
  //Winch Servo
  public void changeAngle(double angle){
    winchServo.setAngle(angle);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
