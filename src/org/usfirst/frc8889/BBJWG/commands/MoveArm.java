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
import org.usfirst.frc8889.BBJWG.RobotMap;
import org.usfirst.frc8889.BBJWG.XboxController;
/**
 *
 */
public class  MoveArm extends Command {
    private double currentSetPoint;
    private double movetoSetPoint;
    
    public MoveArm() {
        // Use requires() here to declare subsystem dependencies
	requires(Robot.bridgeArm);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.bridgeArm.enable();
        currentSetPoint = Robot.bridgeArm.getPosition();
        
        movetoSetPoint = currentSetPoint - 0.2;           
        
        // if (Robot.oi.xbox1.getAxis(XboxController.AxisType.kDLeftRight) > 0.0) {
        //    currentSetPoint += 0.2;
        //    System.out.println("D + new set point" + currentSetPoint);            
        // }
        // else {
        //     currentSetPoint -= 0.2;
        //      System.out.println("D - new set point" + currentSetPoint);
        // }        
        // add limit range criteria
        if (movetoSetPoint >= RobotMap.POTOUTVOLTAGE && movetoSetPoint <= RobotMap.POTSTOWVOLTAGE){
            Robot.bridgeArm.setSetpoint(movetoSetPoint);
        }
        else {
            Robot.bridgeArm.setSetpoint(currentSetPoint);
        }
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {      
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.bridgeArm.onTarget();
    }
    // Called once after isFinished returns true
    protected void end() {
        // let PID loop manage with new target
        // Robot.bridgeArm.stop();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        // let PID loop manage with new target
        // Robot.bridgeArm.stop();
    }
}
