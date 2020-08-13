package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  CANSparkMax motor;
  CANEncoder encoder;


  public Shooter(CANSparkMax m) {
    this.motor = m;
    this.encoder = m.getEncoder();
  }

  public void setSpeed(double speed) {
    motor.set(speed);
  }

  public double getSpeed() {
    return motor.get();
  }

  public int getEncoderCPR(){
    return encoder.getCountsPerRevolution();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("CPR", getEncoderCPR());
  }
}
