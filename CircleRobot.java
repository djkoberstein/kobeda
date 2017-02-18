package kobeda;
import robocode.*;
import java.util.*;

//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * CircleRobot - a robot by (your name here)
 */
public class CircleRobot extends AdvancedRobot
{
	private String targetRobot;
	private HashMap<String, RobotData> robotMap;

	/**
	 * run: CircleRobot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		robotMap = new HashMap<String, RobotData>();

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			turnRadarLeft(10000);
			this.PointAt(targetRobot);
		}
	}

	public void PointAt(String target)
	{
		double x = getX();
		double y = getY();
		RobotData robot = this.robotMap.get(this.targetRobot);
		double targetGunHeading = Math.atan((robot.Y-y)/(robot.X-x));
		double currentGunHeading = getGunHeading();
		double turnAngle = currentGunHeading - targetGunHeading;
		setTurnGunLeft(turnAngle);
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		double distance = e.getDistance();
		double bearing = e.getBearing();

		RobotData robot = new RobotData();
		robot.X = 10; // TODO: calculate x and y
		robot.Y = 10;
		robot.Energy = e.getEnergy();
		robot.Heading = e.getHeading();
		robotMap.put(e.getName(), robot);
		if (targetRobot == "")
		{
			targetRobot = e.getName();
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
