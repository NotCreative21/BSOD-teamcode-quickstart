package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.technototes.library.logger.Loggable;
import com.technototes.library.structure.CommandOpMode;

import org.firstinspires.ftc.teamcode.Controls;
import org.firstinspires.ftc.teamcode.Hardware;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "Example")
public class ExampleOpMode extends CommandOpMode implements Loggable {
    public Hardware hardware;
    public Robot robot;
    public Controls controls;

    @Override
    public void uponInit() {
        hardware = new Hardware();
        robot = new Robot(hardware);
        controls = new Controls(robot, driverGamepad);
    }
}
