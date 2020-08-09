package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Climber extends SubsystemBase{
    
    public static DoubleSolenoid doubleSolenoid;
    public static TalonSRX leaderTalon, followerTalon;

    public Climber() {
        doubleSolenoid = new DoubleSolenoid(Constants.ClimberDoubleSolenoied1, Constants.ClimberDoubleSolenoied2);
        leaderTalon = new TalonSRX(Constants.ClimberTalonSRX1);
        followerTalon = new TalonSRX(Constants.ClimberTalonSRX2);
        followerTalon.follow(leaderTalon);
    }

    /*
    Changing talons speed by demand.    
    */
    public void setLifterSpeed(double demand) {
        leaderTalon.set(ControlMode.PercentOutput, demand);
    }

    /*
    Changing double solenoid stat (open / close).
    */
    public void setHangerStat(boolean value) {
        doubleSolenoid.set(value? Value.kForward : Value.kReverse);
    }

    @Override
    public void periodic() {}
}