/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ShooterCommands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An AccelerateToSpeed command that uses a shooter subsystem.
 */
public class AccelerateToSpeed extends CommandBase {
  private final Shooter shooter;
  private double targetSpeed;
  private double range;

  /**
   * Creates a new AccelerateToSpeed.
   *
   * @param shooter The subsystem used by this command.
   */
  public AccelerateToSpeed(Shooter s, double target, double range) {
    shooter = s;
    targetSpeed = target;
    this.range = range;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(s);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.setVelocityTarget(targetSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Returns true when the command should end.
  int counter = 0;
  @Override
  public boolean isFinished() {
    if ( Math.abs(targetSpeed - shooter.getVelocity()) <= range){
        counter ++;
    }
    else {
        counter = 0;
    }
    return counter > 5;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }
}