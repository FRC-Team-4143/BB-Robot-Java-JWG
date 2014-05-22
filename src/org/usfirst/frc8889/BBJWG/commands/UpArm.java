// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc8889.BBJWG.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc8889.BBJWG.Robot;
/**
 *
 */
public class  UpArm extends Command {
    public UpArm() {       
        requires(Robot.bridgeArm);    
    }
    // Called just before this Command runs the first time
    protected void initialize() {        
        Robot.bridgeArm.enable();
        Robot.bridgeArm.setSetpoint(1.7);    
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
        return Robot.bridgeArm.onTarget();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
    }
    // Called once after isFinished returns true
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
