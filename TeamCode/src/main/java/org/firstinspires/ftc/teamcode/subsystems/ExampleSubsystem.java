package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.technototes.library.hardware.motor.Motor;
import com.technototes.library.subsystem.Subsystem;

import java.util.function.Supplier;

public class ExampleSubsystem implements Subsystem, Supplier<Double> {


    @Config
    public static class ExampleConstants{
        public static int INT = 1;
    }
    public final Motor<DcMotorEx> motor;
    public ExampleSubsystem(Motor<DcMotorEx> m){
        motor = m;
    }

    public void set(){
        motor.setSpeed(ExampleConstants.INT);
    }

    public void stop(){
        motor.setSpeed(0);
    }

    @Override
    public Double get() {
        return motor.get();
    }
}
