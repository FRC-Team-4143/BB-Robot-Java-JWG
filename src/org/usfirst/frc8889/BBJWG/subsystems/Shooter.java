// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc8889.BBJWG.subsystems;
import org.usfirst.frc8889.BBJWG.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc8889.BBJWG.commands.ShooterControl;
/**
 *
 */
public class Shooter extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController motorShooter = RobotMap.shooterMotorShooter;
    Relay spikeShooterLights = RobotMap.shooterSpikeShooterLights;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	setDefaultCommand(new ShooterControl());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void shoot (double shooterSpeed) {
        motorShooter.set(shooterSpeed);
        if (Math.abs(shooterSpeed) > 0.5) {
            spikeShooterLights.set(Relay.Value.kForward);   
        } else {
            spikeShooterLights.set(Relay.Value.kOff);   
        }
    }
    
    public void stop () {
        // not used currently , stop used by lights on, maybe not correct to do it this way...
        // motorShooter.set(0);
        spikeShooterLights.set(Relay.Value.kOff);
    }
    
    public void lightsOn () {        
        spikeShooterLights.set(Relay.Value.kForward);                
    }
}
