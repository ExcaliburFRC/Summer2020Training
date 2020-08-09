# Commands
## Notes:
- the commands for each subsystem are in a subfolder named with the subsystem's name in lowercase
- if command can easily be built using library command types,
    have `<Command>()` as a static method in `<Subsystem>Commands.java`
    instead of new class
    - add parameters to builder function as needed
- receive required subsystem object and `<Boolean/Double>Supplier`s as params
## Commands

### Intake
- ##### `<Open/Close>Intake`: 
    - Opens/Closes intake piston 
- ##### `ControlIntakeMode`: 
    - Sets intake mode
    
### Shooter:
- ##### `AccelerateToSpeed`: 
    - Accelerates shooter to speed

### Climber:
- ##### `<Open/Close>Hanger`:
    - Opens/Closes the hanger piston
- ##### `ManualClimb`: 
    - Raw speed (`PercentOutput`) control of lifter motors

### Indexer:
- ##### Indexer Control Commands:
    - commands that run a motor as long as they run (for each motor)
    
### Drivetrain:
- ##### `ArcadeDrive`:
    - drives using arcade drive (from `DifferentialDrive` object)