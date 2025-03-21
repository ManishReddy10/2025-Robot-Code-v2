// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class deployIntakeUntilIntakeCANrange extends Command {
  Intake m_Intake;
  /** Creates a new deployIntakeUntilIntakeCANrange. */
  public deployIntakeUntilIntakeCANrange(Intake intake) {
    m_Intake = intake;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Intake.goToDeployedPosition();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Intake.goToFramePerimeterPosition();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_Intake.getIntakeCANrangeBeamBreak();
  }
}
