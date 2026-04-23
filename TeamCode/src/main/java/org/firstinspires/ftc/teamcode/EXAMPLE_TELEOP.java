package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.HARDWAREMAP;
import org.firstinspires.ftc.teamcode.teleopSubsystems.Drive;
import java.util.List;


@Config
@TeleOp(name = "EXAMPLE TELE")
public class EXAMPLE_TELEOP extends LinearOpMode {

    public HARDWAREMAP robot = new HARDWAREMAP();
    private Drive drive;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        drive = new Drive(robot);

        telemetry.setMsTransmissionInterval(5);
        telemetry.update();
        waitForStart();


        while (opModeIsActive()) {

            drive.drive(
            gamepad1.left_stick_y,
            gamepad1.left_stick_x * -1.1,
            gamepad1.right_stick_x
            );

            }


        }
    }

