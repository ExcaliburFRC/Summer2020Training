/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class ClimberConstants {
        public static final int HANGER_FWD = 1;
        public static final int HANGER_REV = 2;
        public static final int LEADER_LIFTER_ID = 1;
        public static final int FOLLOWER_LIFTER_ID = 2;
    }
    public static class ShooterConstants {
        public static final int FLYWHEEL_ID = 30;
    }
    public static final class DriveConstants {
        public static final int RIGHT_LEADER_ID = 1;
        public static final int RIGHT_FOLLOWER_ID = 2;
        public static final int LEFT_LEADER_ID = 3;
        public static final int LEFT_FOLLOWER_ID = 4;
    }
}
