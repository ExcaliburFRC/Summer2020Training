package frc.robot.subsystems;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
	private CANSparkMax motor;
	private CANEncoder encoder;
	private CANPIDController controller;

	public Shooter() {
		this.motor = new CANSparkMax(ShooterConstants.FLYWHEEL_ID, MotorType.kBrushless);
		this.encoder = motor.getEncoder();
		this.controller = motor.getPIDController();
	}

	public void setVelocityTarget(double speed) {
		controller.setReference(speed, ControlType.kVelocity);
	}

	public void stopFlywheel() {
		motor.set(0.0);
	}

	public double getVelocity() {
		return encoder.getVelocity();
	}

	@Override
	public void periodic() {
	}
}
