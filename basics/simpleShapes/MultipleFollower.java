package simpleShapes;

import mcm.graphics.ImageShape;

public class MultipleFollower extends mcm.theater.Actor {
	public void act() {
		// dress as an ant 
		setShape(new ImageShape("simpleShapes/res/ant.jpg", getStage()));
		// leave no movement trail
		setTrailVisible(false);

		MultipleFollower follower;
		// create clone
		follower = new MultipleFollower();

		// position follower at this actor's position
		follower.jumpTo(getPos());

		// assign this actor's ditection to follower
		follower.setDirection(getDirection());

		// start follower in 10 clock ticks
		follower.start(getStage(), 10);

		// move until reaching the stage's edge
		while (getStage().isInside(getPos())) {
			move(getStepSize());
		}
	}

}