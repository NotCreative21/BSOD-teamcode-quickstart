package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.technototes.library.logger.Log;
import com.technototes.library.logger.Loggable;
import com.technototes.library.util.Color;

import org.firstinspires.ftc.teamcode.subsystems.ExampleSubsystem;

public class Robot implements Loggable {
    @Config
    public static class RobotConstants{
        public static boolean EXAMPLE_CONNECTED = true;
    }

    public final Hardware hardware;

    @Log(entryColor = Color.RED)
    public ExampleSubsystem exampleSubsystem;

    public Robot(Hardware h) {
        hardware = h;
        if(RobotConstants.EXAMPLE_CONNECTED) exampleSubsystem = new ExampleSubsystem(hardware.motor);
    }
}
