package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;


public class Climber extends SubsystemBase {

    private DoubleSolenoid hanger;
    public static TalonSRX leaderLifter, followerLifter;

    public Climber() {
        hanger = new DoubleSolenoid(ClimberConstants.HANGER_FWD, ClimberConstants.HANGER_REV);
        leaderLifter = new TalonSRX(ClimberConstants.LEADER_LIFTER_ID);
        followerLifter = new TalonSRX(ClimberConstants.FOLLOWER_LIFTER_ID);
        followerLifter.follow(leaderLifter);
    }

    /**
    Changing talons speed by demand.
    */
    public void setLifterSpeed(double speed) {
        leaderLifter.set(ControlMode.PercentOutput, speed);
    }

    /**
    Changing double solenoid state (open / close).
    */
    public void setHangerState(boolean value) {
        hanger.set(value ? Value.kForward : Value.kReverse);
    }

    @Override
    public void periodic() {
    }
}