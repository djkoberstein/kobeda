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
			PointAt(targetRobot);
			double gunHeading = getGunHeading();
			RobotData targetRobot = this.robotMap.get(this.targetRobot);
			// Replace the next 4 lines with any behavior you would like
			// ahead(100);
			// turnGunRight(360);
			// back(100);
			// turnGunRight(360);
		}
	}

	public void PointAt(string target)
	{
		double x = getX();
		double y = getY();
		RobotData robot = this.robotMap.get(this.targetRobot);
		double targetGunHeading = Math.atan((robot.Y-y)/(robot.X-x));
		double currentGunHeading = getGunHeading();
		
		
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		RobotData robotData = new RobotData();
		//robotMap.put(e.getName(), e);
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
