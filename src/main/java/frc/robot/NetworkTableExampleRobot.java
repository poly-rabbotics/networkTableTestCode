
package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;

public class NetworkTableExampleRobot extends TimedRobot {
    public Joystick joystick;
    public NetworkTableEntry yaw;
    public NetworkTableEntry isDriverMode;

    public void robotInit() {
        // Gets the joystick connected to port 1
        joystick = new Joystick(1);

        // Gets the default instance of NetworkTables
        NetworkTableInstance table = NetworkTableInstance.getDefault();

        // Gets the MyCamName table under the chamelon-vision table
        // MyCamName will vary depending on the name of your camera
        NetworkTable cameraTable = table.getTable("chameleon-vision").getSubTable("MyCamName");

        // Gets the yaw to the target from the cameraTable
        yaw = cameraTable.getEntry("yaw");

        // Gets the driveMode boolean from the cameraTable
        isDriverMode = cameraTable.getEntry("driver_mode");
    }

    public void teleopPeriodic() {
        // Prints the yaw to the target
        System.out.println(yaw.getDouble(0.0));

        // Sets driver mode to true if the A button is pressed
        isDriverMode.setBoolean(joystick.getRawButton(0));
    }
}