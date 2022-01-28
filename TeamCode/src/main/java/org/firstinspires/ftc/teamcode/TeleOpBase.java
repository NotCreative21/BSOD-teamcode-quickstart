package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.technototes.library.hardware.motor.Motor;
import com.technototes.library.structure.CommandOpMode;
import com.technototes.library.util.Characters;

@TeleOp(name= Characters.GAMEPAD+" TeleOp")
public class TeleOpBase extends CommandOpMode {
    public Robot robot;
    @Override
    public void uponInit() {
        robot = new Robot();

        driverGamepad.scheduleLeftStick(robot::arcadeDrive);

        driverGamepad.leftBumper.whenPressedReleased(robot::carouselLeft, robot::carouselStop);
        driverGamepad.rightBumper.whenPressedReleased(robot::carouselRight, robot::carouselStop);

        driverGamepad.scheduleRightStick(robot::setArm);

        driverGamepad.dpadUp.whenPressedReleased(robot::raiseArm, robot::stopArm);
        driverGamepad.dpadDown.whenPressedReleased(robot::raiseArm, robot::stopArm);
    }
}
