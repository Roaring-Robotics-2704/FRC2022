// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;

public class Winch extends SubsystemBase {
  /** Creates a new Winch. */
  private WPI_TalonSRX winchTalon = new WPI_TalonSRX(Constants.c_winchTalonMotor);
  private WPI_VictorSPX winchVictor = new WPI_VictorSPX(Constants.c_winchVictorMotor);

  private MotorControllerGroup winchMotors = new MotorControllerGroup(winchTalon, winchVictor);

  public Winch() {
  }

  public void move(double speed){
    winchMotors.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
