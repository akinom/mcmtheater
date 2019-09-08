/**
 * @author Monika Mevenkamp
 * 
 * Start a Leader Actor that bounces around the stage and two Follower Actors; 
 * one follows the leader , the other follows the follower.
 * StepSizes are adjusted such that the followers are slower than their leaders so they 
 * will not be able to ever reach them.
 */
package gallery;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.theater.*;

public class FollowTheLeader extends Actor {
	
	public static Leader startLeaderAndFollowers(Stage stage, int rounds, double stp, double shapeSize) 
	{
		// rounds < 0: leader runs forever 
		// rounds > 0: leader does given # of rounds 
		Leader a = new Leader();
		a.setRounds(rounds);
		a.setShape(new EllipseShape(shapeSize, shapeSize, true));
		a.setColor(Color.BLUE);
		a.setTrailVisible(false);
		a.setStepSize(stp * 2.3);
		a.start(stage);

		Follower f;
		f = new Follower(a, .15);
		f.setStepSize(stp * 1.5);
		f.setShape(new EllipseShape(shapeSize, shapeSize, true));
		f.setColor(new Color(239, 121, 31));
		f.setLineWidth(f.getTrailWidth());
		f.setTrailColor(f.getColor());
		f.setTrailVisible(true);
		f.start(stage, 1);

		f = new Follower(f, .25);
		f.setStepSize(stp * 1.0);
		f.setShape(new EllipseShape(shapeSize, shapeSize, true));
		f.setColor(new Color(225, 229, 2));
		f.setLineWidth(f.getTrailWidth());
		f.setTrailColor(f.getColor());
		f.setTrailVisible(true);
		f.start(stage, 10);

		f = new Follower(f, 0.30);
		f.setStepSize(stp * 0.75);
		f.setShape(new EllipseShape(shapeSize, shapeSize, true));
		f.setColor(new Color(177, 239, 19));
		f.setLineWidth(f.getTrailWidth());
		f.setTrailColor(f.getColor());
		f.setTrailVisible(true);
		f.start(stage, 20);
		
		return a;
	}
	
	public void act() {
		startLeaderAndFollowers(getStage(), -1, getStepSize(), 17); 
	}
}