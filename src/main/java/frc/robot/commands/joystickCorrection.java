/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class joystickCorrection extends Command {
  public joystickCorrection() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveSub.ADGyro.reset();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double yaw = Robot.driveSub.ADGyro.getAngle();
    
      
  
      
    double yawIntensity = yaw / 100;

    Robot.driveSub.setRight(0.5 - yawIntensity);
    Robot.driveSub.setLeft(0.5 + yawIntensity);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveSub.ADGyro.reset();
    Robot.driveSub.setLeft(0);
    Robot.driveSub.setRight(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
