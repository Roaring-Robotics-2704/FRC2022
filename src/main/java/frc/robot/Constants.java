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
    //ports
    //drive motors
    public static int c_frontRightMotor = 2;
    public static int c_frontLeftMotor = 1;
    public static int c_backRightMotor = 4;
    // use to be 3 but I changed it for the actual 2022 robot 
    public static int c_backLeftMotor = 3;
    // use to be 4 but I changed it for the actual 2022 robot
   
    //winch motor
    public static int c_winchTalonMotor = 7;
    public static int c_winchVictorMotor = 8;
    //winch servo
    public static int c_winchServo = 9;
   
    //arm motor
    public static int c_armMotor = 5;
   
    //ball
    public static int c_ballActuator = 1;
    public static int c_ballServo = 0;
    
    //joystick
    public static int c_joystickMain = 0;
    public static int c_joystickButton = 1;
    
    //drivetrain
    public static double c_deadBand = 0.00;
    public static double c_inputScaling = 1;

    public static double c_driveSpeed = 0.6;
    public static double c_turnSpeed = 0.6;

    //actuator
    public static double c_upperPostion = 0.75;
    public static double c_lowerPostion = -0.50;

    //ballServo
    public static double c_upperAngle = 180;
    public static double c_lowerAngle = 105;
}
