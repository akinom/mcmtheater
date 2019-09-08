/**
 * @author Monika Mevenkamp
 * 
 * see also FollowTheLeader and Leader
 */

package gallery;

import mcm.graphics.Point;
import mcm.theater.*;
import mcm.utils.Dice;

/*
 * A Follower follows its Leader by periodically checking it's leader's position
 * and moving a given percentage of the distance between itself and its leader
 * along the line from its current position to its leader's position
 */
class Follower extends Actor {
	Actor leader;

	double percent;

	public Follower(Actor a, double percnt) {
		leader = a;
		percent = percnt;
	}

	public void act() {
		jumpTo(Dice.throwPoint(getStage())); // start at random position on
											 // stage

		while (true) {
			/*
			 * compute the position (newx,newy) that is percent of the way along
			 * the line from this actor's and it's leader's current position
			 */
			Point myPos = getPos();
			Point leaderPos = leader.getPos();
			double deltax = leaderPos.x - myPos.x;
			double deltay = leaderPos.y - myPos.y;
			double newx = myPos.x + (int) (percent * deltax);
			double newy = myPos.y + (int) (percent * deltay);
			moveTo(newx, newy);
		}
	}
}