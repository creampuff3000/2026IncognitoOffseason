package org.firstinspires.ftc.teamcode.teleopSubsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.HARDWAREMAP;

/**
 * Drive subsystem — handles mecanum wheel power calculations and output.
 * Pass in the shared newHWmap instance from the OpMode.
 */
public class Drive {

    private final HARDWAREMAP robot;
    private double speed = 1.0;
    private double hi = 1.9;
    public Drive(HARDWAREMAP robot) {
        this.robot = robot;

        robot.fLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.fRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.bLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.bRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void drive(double leftStickY, double leftStickX, double rightStickX) {
        double y  = -leftStickY;
        double x  = leftStickX * -1.1;
        double rx = rightStickX;

        double denominator     = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower  = (y + x + rx) / denominator;
        double backLeftPower   = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower  = (y + x - rx) / denominator;

        robot.fLeftWheel.setPower(frontLeftPower  * speed);
        robot.bLeftWheel.setPower(backLeftPower   * speed);
        robot.fRightWheel.setPower(frontRightPower * speed);
        robot.bRightWheel.setPower(backRightPower  * speed);
    }

    public void resetEncoders() {
        robot.fLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.fRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.bLeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.bRightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.fLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.fRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.bLeftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.bRightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}