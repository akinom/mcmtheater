package simpleShapes;

import mcm.theater.Actor;

public class Line extends Actor {

	public void act() {
		move(getStage().getWidth());
	}

}
