package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  CANSparkMax motor;

  public Shooter(CANSparkMax m){
    this.motor = m;
  }

  public void setSpeed(double speed) {
    motor.set(speed);
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
