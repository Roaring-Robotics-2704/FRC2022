// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.Camera;
import frc.robot.subsystems.BallActuator_Servo;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Winch;

import frc.robot.commands.Auto;
import frc.robot.commands.BallActuatorCommand;
import frc.robot.commands.BallAutonomous;
import frc.robot.commands.BallServoCommand;
import frc.robot.commands.DriveRobot;
import frc.robot.commands.WinchCommand;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //Subsytems defined
  public static BallActuator_Servo m_ballActuatorServo = new BallActuator_Servo();
  public static Camera camera = new Camera();
  public static Drivetrain m_driveTrain = new Drivetrain();
  public static Winch m_winch = new Winch();
  
  //Commands defined
  public static Auto m_autonomous = new Auto();
  public static BallActuatorCommand m_ballActuatorCommand = new BallActuatorCommand();
  public static BallAutonomous m_ballAuto = new BallAutonomous();
  public static BallServoCommand m_ballServoCommand = new BallServoCommand();
  public static DriveRobot m_driveRobot = new DriveRobot();
  public static WinchCommand m_winchCommand = new WinchCommand();
 
  //OI defined
  public static Joystick joystickMain = new Joystick(Constants.c_joystickMain);
  public static Joystick joystickExtraButton = new Joystick(Constants.c_joystickButton);
 
  //Main Joystick
  public static JoystickButton upWinchButton = new JoystickButton(joystickMain, 6);
  public static JoystickButton downWinchButton = new JoystickButton(joystickMain, 4);

  public static JoystickButton winchServoButton = new JoystickButton(joystickMain, 1);

  public static JoystickButton addTurnSpeed = new JoystickButton(joystickMain, 12);
  public static JoystickButton subtractTurnSpeed = new JoystickButton(joystickMain, 11);

  public static JoystickButton addDriveSpeed = new JoystickButton(joystickMain, 10);
  public static JoystickButton subtractDriveSpeed = new JoystickButton(joystickMain, 9);

  public static JoystickButton ballServoButton = new JoystickButton(joystickMain, 5);
  public static JoystickButton ballActuatorButton = new JoystickButton(joystickMain, 3);

  //Secondary Joystick
  public static JoystickButton addTurnSpeedSecondary = new JoystickButton(joystickExtraButton, 12);
  public static JoystickButton subtractTurnSpeedSecondary = new JoystickButton(joystickExtraButton, 11);

  public static JoystickButton addDriveSpeedSecondary = new JoystickButton(joystickExtraButton, 10);
  public static JoystickButton subtractDriveSpeedSecondary  = new JoystickButton(joystickExtraButton, 9);

  //Chooser for autonomous
  SendableChooser<Boolean> autoChooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //Connects the subsystem to the command
    m_ballActuatorServo.setDefaultCommand(m_ballActuatorCommand);
    m_ballActuatorServo.setDefaultCommand(m_ballServoCommand);
    m_driveTrain.setDefaultCommand(m_driveRobot);
    m_winch.setDefaultCommand(m_winchCommand);
    autoChooser.setDefaultOption("Normal", true);
    autoChooser.addOption("Taxi Only", false);
    SmartDashboard.putData("Autonomous Mode", autoChooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    upWinchButton.whenPressed(new WinchCommand());
    downWinchButton.whenPressed(new WinchCommand());

    winchServoButton.whenPressed(new WinchCommand());

    addTurnSpeed.whenPressed(new DriveRobot());
    subtractTurnSpeed.whenPressed(new DriveRobot());

    addDriveSpeed.whenPressed(new DriveRobot());
    subtractDriveSpeed.whenPressed(new DriveRobot());

    ballActuatorButton.whenPressed(new BallActuatorCommand());
    ballServoButton.whenPressed(new BallServoCommand());
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    m_autonomous.mode = autoChooser.getSelected();
    return m_autonomous;
  }
}
