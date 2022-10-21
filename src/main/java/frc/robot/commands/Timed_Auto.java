// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Timed_Auto extends CommandBase {
  
  private final Timer timer = new Timer();
  private final DriveTrain drive = new DriveTrain();
  
  public Timed_Auto() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    timer.reset();
    addRequirements(drive);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    timer.start();
  }
  

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if(timer.get() < 2) drive.tankDrive(0.3,0.3);
    else if(timer.get() < 3 ) drive.tankDrive(-0.3,-0.3);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    
    if (timer.get()>3){
      return true;
    }
    else{
      return false;
    }
  
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  
}
