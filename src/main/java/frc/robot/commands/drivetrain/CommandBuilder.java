package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
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
}
