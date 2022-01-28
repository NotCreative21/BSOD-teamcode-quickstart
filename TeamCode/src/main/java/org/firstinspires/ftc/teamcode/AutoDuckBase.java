package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.technototes.library.command.Command;
import com.technototes.library.command.CommandScheduler;
import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;
import com.technototes.library.structure.CommandOpMode;
import com.technototes.library.util.Alliance;
import com.technototes.library.util.Characters;

public abstract class AutoDuckBase extends CommandOpMode {
    public Robot robot;
    @Override
    public void uponInit() {
        robot = new Robot();
        CommandScheduler.getInstance().scheduleOnceForState(getAutonomousCommand()
                .andThen(CommandScheduler.getInstance()::terminateOpMode),
                OpModeState.RUN);

    }

    public abstract Command getAutonomousCommand();


    @Autonomous(name = Characters.RED_SQUARE+" "+Characters.DUCK+" Red Duck Auto")
    public static class RedDuckAuto extends AutoDuckBase {
        @Override
        public Command getAutonomousCommand() {
            return new SequentialCommandGroup(
                    ()->robot.drive(0.3, 0.3),
                    new WaitCommand(0.3),
                    robot::carouselLeft,
                    new WaitCommand(5),
                    robot::carouselStop,
                    ()->robot.drive(0, 0.5),
                    new WaitCommand(1),
                    ()->robot.drive(-0.3, -0.3),
                    new WaitCommand(1)
            );
        }
    }

    @Autonomous(name = Characters.BLUE_CIRCLE+" "+Characters.DUCK+" Blue Duck Auto")
    public static class BlueDuckAuto extends AutoDuckBase {
        @Override
        public Command getAutonomousCommand() {
            return new SequentialCommandGroup(
                    ()->robot.drive(-0.3, -0.3),
                    new WaitCommand(0.3),
                    robot::carouselLeft,
                    new WaitCommand(5),
                    robot::carouselStop,
                    ()->robot.drive(0, 0.5),
                    new WaitCommand(1),
                    ()->robot.drive(0.3, 0.3),
                    new WaitCommand(1)
            );
        }
    }
}
