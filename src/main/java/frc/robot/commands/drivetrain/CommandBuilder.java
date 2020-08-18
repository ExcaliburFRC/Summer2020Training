package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;

public class CommandBuilder {
	public static Command buildArcadeDrive(DriveTrain driveTrain, DoubleSupplier xSpeed, DoubleSupplier zRotation) {
		Command result;
		result = new RunCommand(() -> {
			driveTrain.arcadeDrive(xSpeed.getAsDouble(), zRotation.getAsDouble());
		}, driveTrain);

		return result;
	}

	public static Command buildRotateToAngle(DriveTrain driveTrain, DoubleSupplier errorSupplier) {
		Command result;

		PIDController controller = new PIDController(DriveConstants.ANGLE_KP, DriveConstants.ANGLE_KI,
				DriveConstants.ANGLE_KD);
		result = new PIDCommand(controller, errorSupplier, 0.0, (double output) -> {
			driveTrain.arcadeDrive(0, output);
		}, driveTrain);

		return result;
	}

	public static Command buildRotateByAngle(DriveTrain driveTrain, double angle) {
		Command result;
		result = buildRotateToAngle(driveTrain, () -> {
			return angle - driveTrain.getGyro();
		});

		return result;
	}
}
