package simpleShapes;

import mcm.theater.Actor;

class MoveDashed extends Actor {
	double dist  = 25;

	public void setDist(double d) {
		dist = d;
	}

	public void act() {
		while (getStage().isInside(getPos())) {
			setTrailVisible(false);
			move(dist);
			setTrailVisible(true);
			move(dist);
		}
	}
}