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
	private HashMap<String, RobotData> robots;

	/**
	 * run: CircleRobot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
	 robots = new HashMap<String, RobotData>();

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			turnRadarLeft(360);
			Aim();
		}
	}

	private void Aim()
	{
		double x = getX();
		double y = getY();
		RobotData robot = GetNearestRobot();
		double targetGunHeading = Math.atan((robot.Y-y)/(robot.X-x));
		double currentGunHeading = getGunHeading();
		double deltaGunHeading = currentGunHeading - targetGunHeading;
		turnGunLeft(deltaGunHeading);
	}

	RobotData GetNearestRobot()
	{
		Map.Entry<String, RobotData> entry=robots.entrySet().iterator().next();
		return entry.getValue();
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		RobotData robot = new RobotData();
		robot.Energy = e.getEnergy();
		robot.Heading = e.getHeading();
		robot.X = e.getDistance() * Math.cos(e.getBearing());
		robot.Y = e.getDistance() * Math.sin(e.getBearing());
	 robots.put(e.getName(), robot);
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
