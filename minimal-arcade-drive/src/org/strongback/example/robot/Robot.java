/*
 * Strongback
 * Copyright 2015, Strongback and individual contributors by the @authors tag.
 * See the COPYRIGHT.txt in the distribution for a full listing of individual
 * contributors.
 *
 * Licensed under the MIT License; you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.strongback.example.robot;

import org.strongback.Strongback;
import org.strongback.components.Motor;
import org.strongback.components.ui.ContinuousRange;
import org.strongback.components.ui.FlightStick;
import org.strongback.drive.TankDrive;
import org.strongback.hardware.Hardware;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * A minimal tank-drive robot controlled with a Logitech Attack 3D plugged into port 1 on the Driver Station for arcade-style
 * driver input. The robot has one motor on each side, and each motor is controlled by one Talon motor controller. The robot
 * only supports teleoperated mode, does nothing in autonomous, and in test mode starts the {@link LiveWindow}.
 */
public class Robot extends IterativeRobot {

    private static final int JOYSTICK_PORT = 1; // in driver station
    private static final int LEFT_MOTOR_PORT = 1;
    private static final int RIGH_MOTOR_PORT = 2;

    private TankDrive drive;
    private ContinuousRange driveSpeed;
    private ContinuousRange turnSpeed;

    @Override
    public void robotInit() {
        // Set up Strongback using its configurator. This is entirely optional, but we won't record commands, data, or events
        // so it's slightly better if we turn them off. All other defaults are fine.
        Strongback.configure().recordNoCommands().recordNoData().recordNoEvents().initialize();

        // Set up the robot hardware ...
        Motor left = Hardware.Motors.talon(LEFT_MOTOR_PORT);
        Motor right = Hardware.Motors.talon(RIGH_MOTOR_PORT);
        drive = new TankDrive(left, right);

        // Set up the human input controls for teleoperated mode.
        FlightStick joystick = Hardware.HumanInterfaceDevices.logitechAttack3D(JOYSTICK_PORT);
        driveSpeed = joystick.getPitch();
        turnSpeed = joystick.getRoll().invert();
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
        drive.arcade(driveSpeed.read(), turnSpeed.read());
    }

    @Override
    public void disabledInit() {
        Strongback.disable();
    }

    @Override
    public void testInit() {
        LiveWindow.run();
    }

}