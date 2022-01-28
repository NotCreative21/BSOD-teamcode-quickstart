package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.technototes.library.hardware.motor.Motor;
import com.technototes.library.hardware.sensor.ColorSensor;
import com.technototes.library.hardware.servo.Servo;

public class Hardware {
    @Config
    public static class HardwareConstants{
        public static String MOTOR_ID = "motor";
        public static String SERVO_ID = "servo";
    }

    public Motor<DcMotorEx> motor;

    public Servo servo;

    public ColorSensor colorSensor;

    public Hardware(){
        if(Robot.RobotConstants.EXAMPLE_CONNECTED){
            motor = new Motor<>(HardwareConstants.MOTOR_ID);
            servo = new Servo(HardwareConstants.SERVO_ID);
        }
        colorSensor = new ColorSensor("color");
    }
}
