// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.BallActuatorCommand;
import frc.robot.commands.BallServoCommand;
import frc.robot.commands.DriveRobot;
import frc.robot.commands.WinchCommand;
import frc.robot.subsystems.BallActuator_Servo;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Winch;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Camera;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //Subsytems defined
  public static Drivetrain m_driveTrain = new Drivetrain();
  public static BallActuator_Servo m_ballActuator = new BallActuator_Servo();
  public static Winch m_winch = new Winch();
  public static Arm m_arm = new Arm();
  public static Camera camera = new Camera();

  //Commands defined
  public static DriveRobot m_driveRobot = new DriveRobot();
  public static BallActuatorCommand m_ballActuatorCommand = new BallActuatorCommand();
  public static BallServoCommand m_ballServoCommand = new BallServoCommand();
  public static WinchCommand m_winchCommand = new WinchCommand();
  public static ArmCommand m_armCommand = new ArmCommand();

  //OI defined
  public static Joystick joystickMain = new Joystick(Constants.c_joystickMain);
  public static Joystick joystickButton = new Joystick(Constants.c_joystickButton);

  public static JoystickButton upWinchButton = new JoystickButton(joystickMain, 6);
  public static JoystickButton downWinchButton = new JoystickButton(joystickMain, 4);

  public static JoystickButton upArmButton = new JoystickButton(joystickMain, 7);
  public static JoystickButton downArmButton = new JoystickButton(joystickMain, 8);

  public static JoystickButton addTurnSpeed = new JoystickButton(joystickMain, 12);
  public static JoystickButton subtractTurnSpeed = new JoystickButton(joystickMain, 11);

  public static JoystickButton addDriveSpeed = new JoystickButton(joystickMain, 10);
  public static JoystickButton subtractDriveSpeed = new JoystickButton(joystickMain, 9);

  public static JoystickButton ballServoButton = new JoystickButton(joystickMain, 3);
  public static JoystickButton ballActuatorButton = new JoystickButton(joystickMain, 5);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //Connects the subsystem to the command
    m_driveTrain.setDefaultCommand(m_driveRobot);
    m_ballActuator.setDefaultCommand(m_ballServoCommand);
    m_ballActuator.setDefaultCommand(m_ballActuatorCommand);
    m_winch.setDefaultCommand(m_winchCommand);
    m_arm.setDefaultCommand(m_armCommand);
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

    upArmButton.whenPressed(new ArmCommand());
    downArmButton.whenPressed(new ArmCommand());

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
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  //}
}
