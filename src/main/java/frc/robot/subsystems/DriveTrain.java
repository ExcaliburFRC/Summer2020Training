package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

    private CANSparkMax rightLeaderMotor, rightFollowerMotor, leftLeaderMotor, leftFollowerMotor;
    private CANEncoder rightEncoder, leftEncoder;
    private DifferentialDrive differentialDrive;
    private AHRS gyro;

    public DriveTrain() {
        rightLeaderMotor = new CANSparkMax(Constants.RLM, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightFollowerMotor = new CANSparkMax(Constants.RFM, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightFollowerMotor.follow(rightLeaderMotor);

        leftLeaderMotor = new CANSparkMax(Constants.LLM, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftFollowerMotor = new CANSparkMax(Constants.LFM, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightFollowerMotor.follow(leftLeaderMotor);

        rightEncoder = rightLeaderMotor.getAlternateEncoder();
        leftEncoder = leftLeaderMotor.getAlternateEncoder();

        differentialDrive = new DifferentialDrive(leftLeaderMotor, rightLeaderMotor);

        gyro = new AHRS();

    }

    public void arcadeDrive(double speed, double rotation) {
        differentialDrive.arcadeDrive(speed, rotation);
    }

    public double getGyro() {
        return gyro.getAngle();
    }

    public void resetGyro() {
        gyro.reset();
    }

    public double getRightEncoder() {
        return rightEncoder.getPosition();
    }

    public void resetRightEncoder() {
        rightEncoder.setPosition(0);
    }

    public double getLeftEncoder() {
        return leftEncoder.getPosition();
    }

    public void resetLeftEncoder() {
        leftEncoder.setPosition(0);
    }

    @Override
    public void periodic() {

    }
}
