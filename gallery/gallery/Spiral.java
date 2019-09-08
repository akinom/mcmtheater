package gallery;

import mcm.theater.*;
import mcm.utils.Dice;

/**
 * A Spiral actor draws a Spiral by alternating between moving forward ever
 * increasing distances and turning right. A Spiral Actor finishes when its move
 * distance reaches a maximum length.
 * 
 * Each Spiral actor chooses a random color for its trail.
 * 
 * Each Spiral actor creates a copy of itself and schedules it to start
 * startDelay ticks on the stage's clock in the future. The copy overwrites its
 * creator's path in its own trail color, since it starts in the same direction
 * and at the same point as the creator.
 */
public class Spiral extends Actor {
	int minLength;

	int maxLength;

	int deltaLength;

	int startDelay;

	Spiral follower;

	/*
	 * construct a Spiral actor with a minimum/maximum sidelength of min/max, a
	 * sidlelength increment of delta, and a startDelay of deltaTime
	 */
	public Spiral(int min, int max, int deltaLen, int deltaTime) {
		minLength = min;
		maxLength = max;
		deltaLength = deltaLen;
		startDelay = deltaTime;
		follower = null;
		setVisible(false);
	}

	public void act() {
	if (startDelay > 0) {
			follower = new Spiral(minLength, maxLength, deltaLength, startDelay);
			follower.jumpTo(getPos());
			follower.setDirection(getDirection());
			follower.setTrailWidth(getTrailWidth());
			follower.setStepSize(getStepSize());
			follower.start(getStage(), startDelay);
		}
		setTrailColor(Dice.throwColor());
		int i;
		for (i = minLength; i < maxLength; i = i + deltaLength) {
			move(i);
			left(90);
		}
		move(i - 2 * deltaLength);
	}
}

