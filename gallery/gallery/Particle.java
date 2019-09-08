
package gallery;

import java.awt.Color;

import mcm.graphics.Point;
import mcm.theater.Actor;

/**
 * A Particle Actor moves towards its leader's position until it gets close
 * enough
 */
 public class Particle extends Actor {

	Actor leader;

	void setLeader(Actor l) {
		leader = l;
	}

	public Particle(Color color, double stp) {
		setColor(color);
		setTrailColor(color);
		setStepSize(stp);
		setTrailWidth(2);
	}

	/**
	 * move towards leader's position until close enough by: 
	 *      moving stepSize pixels towards the leader 
	 *      cheking the leader's position again, 
	 *      moving  towards it, rechecking, .... 
	 *      until it gets within stepSize pixels of the leader
	 */
	public void act() {
		double stp = getStepSize();
		double minDistSquare = stp * stp; // minimum distance squared
		while (true) {
			Point myPos = getPos();
			Point leaderPos = leader.getPos();
			double dx = leaderPos.x - myPos.x;
			double dy = leaderPos.y - myPos.y;
			double distSquare = dx * dx + dy * dy;
			if (distSquare > minDistSquare) {
				setDirection(dx, dy); // set slope of movement line
				move(stp);            // move stp pixels
			} else {
				break; // within stp pixels of leader
			}
		}
	}
}