// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveSub extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private TalonSRX tal1;
private TalonSRX tal2;
private TalonSRX tal3;
private TalonSRX tal4;
public TalonSRX tal9;
private Encoder driveRightEncoder;
private Encoder driveLeftEncoder;

public ADXRS450_Gyro ADGyro = new ADXRS450_Gyro();


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveSub() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
tal1 = new TalonSRX(1);
//addChild("Tal1",tal1);
tal1.setInverted(true);
        
tal2 = new TalonSRX(2);
//addChild("Tal2",tal2);
tal2.setInverted(true);
        
tal3 = new TalonSRX(3);
//addChild("Tal3",tal3);
tal3.setInverted(false);
        
tal4 = new TalonSRX(4);
//addChild("Tal4",tal4);
tal4.setInverted(false);


        
driveRightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
addChild("DriveRightEncoder",driveRightEncoder);
driveRightEncoder.setDistancePerPulse(1.0);
driveRightEncoder.setPIDSourceType(PIDSourceType.kRate);
        
driveLeftEncoder = new Encoder(4, 5, false, EncodingType.k4X);
addChild("DriveLeftEncoder",driveLeftEncoder);
driveLeftEncoder.setDistancePerPulse(1.0);
driveLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
public void setRight (double power){
    //1 and 2
    if(!(power == 1) || !(power == -1)){
        tal1.set(ControlMode.PercentOutput, power);
        tal2.set(ControlMode.PercentOutput, power);

    }

    if(power == 1)
    {
        tal1.set(ControlMode.PercentOutput, 0.9);
        tal2.set(ControlMode.PercentOutput, 0.9); 
    }

    if(power == -1)
    {
        tal1.set(ControlMode.PercentOutput, -0.9);
        tal2.set(ControlMode.PercentOutput, -0.9); 
    }
}
public void setLeft (double power){
    //3 and 4
    if(!(power == 1) || !(power == -1)){
        tal3.set(ControlMode.PercentOutput, power);
        tal4.set(ControlMode.PercentOutput, power);

    }

    if(power == 1)
    {
        tal3.set(ControlMode.PercentOutput, 0.9);
        tal4.set(ControlMode.PercentOutput, 0.9); 
    }

    if(power == -1)
    {
        tal3.set(ControlMode.PercentOutput, -0.9);
        tal4.set(ControlMode.PercentOutput, -0.9); 
    }
    


}



public double getRightEncoderDistance(){
    return driveRightEncoder.getDistance();
}
public double getLeftEncoderDistance(){
    return driveLeftEncoder.getDistance();
}

public void resetRightEncoder()
{
    driveRightEncoder.reset();
} 

public void resetLeftEncoder()
{
    driveLeftEncoder.reset();
}


    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

