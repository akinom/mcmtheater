/**
 * @author Monika Mevenkamp 
 * 
 * see also FollowTheLeader and Follower 
 */

package gallery;

import mcm.theater.Actor;
import mcm.utils.Dice;

/*
 * This Leader visits the four corners of the stage jumping to random positions in between 
 */
class Leader extends Actor {
	private int maxRound = -1; 
	
	public void setRounds(int i) {
		maxRound = i;
	}
	
	public void act() {
		double offset = Math.max(getWidth(), getHeight());

		for (int i = 0; i != maxRound; ) {
			moveTo(getStage().getWidth() - offset, offset);  // move to bottom
															 // right position
			moveTo(Dice.throwPoint(getStage()));             // move to random position
			moveTo(getStage().getWidth() - offset, getStage().getHeight()
					- offset);                               // .. to top right corner
			moveTo(Dice.throwPoint(getStage()));             // .. to random pos
			moveTo(offset, getStage().getHeight() - offset); // .. to top left
															 // corner
			moveTo(Dice.throwPoint(getStage()));             // .. to random pos
			moveTo(offset, offset);                          // to lower left corner
			moveTo(Dice.throwPoint(getStage()));             // .. to random pos

			i++; 
			if (i % 8 == 0)
				getStage().clear(); // clear every 25 ticks on the stage's clock 
		}
	}

}