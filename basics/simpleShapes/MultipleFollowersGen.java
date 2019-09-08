package simpleShapes;

import simpleShapes.MultipleFollower;

import mcm.theater.*;

public class MultipleFollowersGen extends Actor {
	public void act() {
		/*
		 * create three MultipleFollower actors 
		 * the first and third move from the left to the right edge of the stage
		 * the second moves from the right to the left
		 */
		Actor a; 
		
		a = new MultipleFollower();
		a.jumpTo(0, 18); 
		a.start(getStage()); 
		
		a = new MultipleFollower();
		a.jumpTo(getStage().getWidth()-1, getStage().getCenter().y); 
		a.setDirection(180);
		a.start(getStage(), 37); 
		
		a = new MultipleFollower();
		a.jumpTo(0, getStage().getCenter().x + 25); 
		a.start(getStage(), 11); 

	}

}
