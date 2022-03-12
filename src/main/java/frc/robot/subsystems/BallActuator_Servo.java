// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PWM;

public class BallActuator_Servo extends SubsystemBase {
  //public Servo actuator = new Servo(Constants.c_ballActuator);
  public PWMTalonFX actuator = new PWMTalonFX(Constants.c_ballActuator);
  public Servo ballServo = new Servo(Constants.c_ballServo);
  public double actuatorPostion;
  
  /** Creates a new BallActuator. */
  public BallActuator_Servo() {
    //actuator.setBounds(2.0, 1.8, 1.5, 1.2, 1.0);
  }
  
  public void moveActuator(){
    if(actuatorPostion == -0.95){
      actuatorPostion = 1;
      actuator.set(actuatorPostion);
    }
    else if(actuatorPostion == 1){
      actuatorPostion = -0.95;
      actuator.set(actuatorPostion);
    }
    
    //Working Acutator
    /*double actuatorPostion = actuator.getPosition();
    if(actuatorPostion == 0){
      actuator.setPosition(1);
    }
    else if(actuatorPostion == 1){
      actuator.setPosition(0);
    } */

  }
  
  public void changeAngle(){
    double ballAngle = ballServo.getAngle();
    if(ballAngle == 20){
      ballServo.setAngle(180);
    }
    else if(ballAngle == 180){
      ballServo.setAngle(20);
    }
  }
  //Working code but not with right angles
  /*public void changeAngle(){
    double ballAngle = ballServo.getAngle();
    if(ballAngle == 180){
      ballServo.setAngle(0);
    }
    else if(ballAngle == 0){
      ballServo.setAngle(180);
    }
  }*/

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
