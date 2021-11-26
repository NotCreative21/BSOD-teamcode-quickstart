package org.firstinspires.ftc.teamcode;

import com.technototes.library.control.gamepad.CommandButton;
import com.technototes.library.control.gamepad.CommandGamepad;

import org.firstinspires.ftc.teamcode.commands.ExampleCommand;

public class Controls {
    public final Robot robot;
    public final CommandButton exampleButton;
    public Controls(Robot r, CommandGamepad g) {
        robot = r;
        exampleButton = g.a;
        if(Robot.RobotConstants.EXAMPLE_CONNECTED) bindExampleControls();
    }
    public void bindExampleControls(){
        exampleButton.whilePressedOnce(new ExampleCommand(robot.exampleSubsystem));
    }
}
