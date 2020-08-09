# Subsystems
## Notes:
- if possible, use `enum`s - expose as little as possible
- all port numbers and other constants should be placed in `Constants.java`
- use normal names for stuff
- when exposing piston states, convert `DoubleSolenoid.Value <==> boolean` so we don't use `Value` outside
- all basic computations should be done _inside_ the subsytem class/functions
- use CAN `follow`ing when relevant (with `leader`/`follower` naming!)

## Subsystems:
### Intake
- `VictorSPX` for intake itself
- `DoubleSolenoid` for opening/closing piston

### Shooter
- `CANSparkMax` for shooter motor
    - uses built-in encoder for velocity measurement (`CANSparkMax.getEncoder()`)

### Indexer
- `VictorSPX` for flickers
- `VictorSPX` for loading
- `Ultrasonic` for checking if we have a ball inside

### Climber
- `DoubleSolenoid` for opening&closing hanger
- 2X `TalonSRX` for lifting robot

### Drivetrain
- `CANSparkMax` for each corner (2 per side)
- `CANSparkMax.getAlternateEncoder()` as encoder on leader Spark for each side
- use a `DifferentialDrive` object to easily control the drivetrain