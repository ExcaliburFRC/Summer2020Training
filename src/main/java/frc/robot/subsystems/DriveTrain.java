package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveTrain extends SubsystemBase {

    private CANSparkMax rightLeaderMotor, rightFollowerMotor, leftLeaderMotor, leftFollowerMotor;
    private CANEncoder rightEncoder, leftEncoder;
    private DifferentialDrive differentialDrive;
    private AHRS gyro;

    public DriveTrain() {
        rightLeaderMotor = new CANSparkMax(DriveConstants.RIGHT_LEADER_ID, MotorType.kBrushless);
        rightFollowerMotor = new CANSparkMax(DriveConstants.RIGHT_FOLLOWER_ID, MotorType.kBrushless);
        rightFollowerMotor.follow(rightLeaderMotor);

        leftLeaderMotor = new CANSparkMax(DriveConstants.LEFT_LEADER_ID, MotorType.kBrushless);
        leftFollowerMotor = new CANSparkMax(DriveConstants.LEFT_FOLLOWER_ID, MotorType.kBrushless);
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
