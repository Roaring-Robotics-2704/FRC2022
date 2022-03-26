// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
    //number that stay constant throughout the code
    //joystick
    public static int c_joystickMain = 0;
    public static int c_joystickButton = 1;

    //drive train
    //motor ports
    public static int c_frontLeftMotor = 1;
    public static int c_frontRightMotor = 2;
    public static int c_backLeftMotor = 3;
    public static int c_backRightMotor = 4;  
    //driving corrections
    public static double c_deadBand = 0.2;
    public static double c_turningDeadBand = 0.25;
    //driver speed contorl
    public static double c_driveSpeed = 0.6;
    public static double c_turnSpeed = 0.6;
    public static double c_speedIncrementIncrease = 0.2;
    public static double c_speedIncrementDecrease = -0.2;
    public static double c_upperSpeedLimit = 2.0;
    public static double c_lowerSpeedLimit = 0.4;

    //winch motor
    //motor ports
    public static int c_winchTalonMotor = 7;
    public static int c_winchVictorMotor = 8;
    public static double c_winchSpeedUp = 1;
    public static double c_winchSpeedDown = -1;
    
    //winch servo
    //ports 
    public static int c_winchServo = 9;
    //angles
    public static int c_lockedAngle = 90;
    public static int c_unlockedAngle = 0;
    
    //ball servo
    //port
    public static int c_ballServo = 1;
    // angles
    public static double c_closedAngle = 180;
    public static double c_openedAngle = 75;

    //ball actuator
    //ports
    public static int c_ballActuator = 0;
    //positions
    public static double c_outPostion = 1;
    public static double c_inPostion = -0.50;

}
