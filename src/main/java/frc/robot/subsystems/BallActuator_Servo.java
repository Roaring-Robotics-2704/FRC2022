// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class BallActuator_Servo extends SubsystemBase {
  //Declared the actuator as a talon in order to allow it to stop at different postions
  //Full out is 1, full in is -1, and middle is 0.5
  public PWMTalonFX actuator = new PWMTalonFX(Constants.c_ballActuator);
  public double actuatorPostion;

  public Servo ballServo = new Servo(Constants.c_ballServo);
  public double servoAngle;
  
  public DigitalInput input = new DigitalInput(0);
  Debouncer debouncerActuator = new Debouncer(0.2, Debouncer.DebounceType.kBoth);
  Debouncer debouncerServo = new Debouncer(0.3, Debouncer.DebounceType.kBoth);
  
  /** Creates a new BallActuator. */
  public BallActuator_Servo() {
  }
  //Ball Actuator
  public void moveActuator(){
    if(debouncerActuator.calculate(input.get())){
      if(actuatorPostion == Constants.c_inPostion){
        actuatorPostion = Constants.c_outPostion;
        actuator.set(actuatorPostion);
      }
      else if(actuatorPostion == Constants.c_outPostion){
        actuatorPostion = Constants.c_inPostion;
        actuator.set(actuatorPostion);
      }
    }
  }
    public void moveActuatorInput(double position) {
      actuator.set(position);
    }

  //Ball Servo
    public void changeAngle(){
      if(debouncerServo.calculate(input.get())){
        if(servoAngle == Constants.c_openedAngle){
          servoAngle = Constants.c_closedAngle;
          ballServo.setAngle(servoAngle);
        }
        else if(servoAngle == Constants.c_closedAngle){
          servoAngle = Constants.c_openedAngle;
          ballServo.setAngle(servoAngle);
        }
      }
    }

public void changeAngleInput(double angle){
  ballServo.setAngle(angle);
}

public double getAngle() {
  return ballServo.getAngle();
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
