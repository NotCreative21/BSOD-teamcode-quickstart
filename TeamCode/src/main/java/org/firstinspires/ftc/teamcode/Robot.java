package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.Range;
import com.technototes.library.hardware.motor.Motor;
import com.technototes.library.hardware.servo.Servo;
import com.technototes.library.logger.Log;
import com.technototes.library.logger.Loggable;
import com.technototes.library.util.Color;

@Config
public class Robot implements Loggable {
    public static double SERVO_OPEN = 1, SERVO_CLOSE=0;
    public static double ARM_UP_SPEED = 0.5, ARM_DOWN_SPEED = -0.5;
    public static double CAROUSEL_LEFT_SPEED, CAROUSEL_RIGHT_SPEED;

    public Motor<DcMotorEx> lDrive1, lDrive2, rDrive1, rDrive2, arm, carousel;
    public Servo cup;
    public Robot(){
        lDrive1 = new Motor<DcMotorEx>("ldrive1");
        lDrive2 = new Motor<DcMotorEx>("ldrive2");
        rDrive1 = new Motor<DcMotorEx>("rdrive1").invert();
        rDrive2 = new Motor<DcMotorEx>("rdrive2").invert();
        arm = new Motor<DcMotorEx>("arm").brake();
        carousel = new Motor<DcMotorEx>("spin").brake();

        cup = new Servo("cup").startAt(SERVO_CLOSE);
    }

    public void arcadeDrive(double x, double y){
        drive(y+2*x, y-2*x);
    }

    public void drive(double left, double right){
        lDrive1.setSpeed(left);
        lDrive2.setSpeed(left);
        rDrive1.setSpeed(right);
        rDrive2.setSpeed(left);
    }

    public void raiseArm(){
        arm.setSpeed(ARM_UP_SPEED);
    }
    public void lowerArm(){
        arm.setSpeed(ARM_DOWN_SPEED);
    }
    public void stopArm(){
        arm.setSpeed(0);
    }
    //oops for the e its not used
    public void setArm(double e, double value){
        arm.setSpeed(Range.clip(ARM_DOWN_SPEED, value, ARM_UP_SPEED));
    }

    public void carouselLeft(){
        carousel.setSpeed(CAROUSEL_LEFT_SPEED);
    }
    public void carouselRight(){
        carousel.setSpeed(CAROUSEL_RIGHT_SPEED);
    }
    public void carouselStop(){
        carousel.setSpeed(0);
    }

    public void open(){
        cup.setPosition(SERVO_OPEN);
    }

    public void close(){
        cup.setPosition(SERVO_CLOSE);
    }

    @Log.Boolean(name="Bucket", index=0,trueValue = "OPEN", trueColor = Color.GREEN, falseColor = Color.RED, falseValue = "CLOSED")
    public boolean getBucket(){
        return cup.getPosition() == SERVO_OPEN;
    }
    @Log.NumberSlider(name="Carousel", index=1, slider = Color.YELLOW, sliderBackground = Color.ORANGE)
    public double getCarousel(){
        return carousel.getSpeed();
    }

}
