package org.firstinspires.ftc.teamcode.commands;

import com.technototes.library.command.Command;

import org.firstinspires.ftc.teamcode.subsystems.ExampleSubsystem;

public class ExampleCommand implements Command {
    public final ExampleSubsystem subsystem;
    public ExampleCommand(ExampleSubsystem s){
        subsystem = s;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        subsystem.set();
    }

    @Override
    public void execute() {
        System.out.println(subsystem.get());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean cancel) {
        subsystem.stop();
    }
}
