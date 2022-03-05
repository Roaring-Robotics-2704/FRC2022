// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

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
  public static BallActuator m_ballActuator = new BallActuator();
  public static Winch m_winch = new Winch();
  public static Arm m_arm = new Arm();

  //Commands defined
  public static DriveRobot m_driveRobot = new DriveRobot();
  public static BallCommand m_ballCommand = new BallCommand();
  public static WinchCommand m_winchCommand = new WinchCommand();
  public static ArmCommand m_armCommand = new ArmCommand();
  public static BallAutonomous ballAuto = new BallAutonomous();

  //OI defined
  public static Joystick joystick = new Joystick(Constants.c_joystick);
  public static JoystickButton downBallActuatorButton = new JoystickButton(joystick, 3);
  public static JoystickButton upBallAcutatorButton = new JoystickButton(joystick, 5);
 
  public static JoystickButton upWinchButton = new JoystickButton(joystick, 6);
  public static JoystickButton downWinchButton = new JoystickButton(joystick, 4);

  public static JoystickButton upArmButton = new JoystickButton(joystick, 7);
  public static JoystickButton downArmButton = new JoystickButton(joystick, 8);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //Connects the subsystem to the command
    m_driveTrain.setDefaultCommand(m_driveRobot);
    m_ballActuator.setDefaultCommand(m_ballCommand);
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
    upBallAcutatorButton.whenPressed(new BallCommand());
    downBallActuatorButton.whenPressed(new BallCommand());

    upWinchButton.whenPressed(new WinchCommand());
    downWinchButton.whenPressed(new WinchCommand());

    upArmButton.whenPressed(new ArmCommand());
    downArmButton.whenPressed(new ArmCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    return ballAuto;
  }
}
