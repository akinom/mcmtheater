package simpleShapes;

import mcm.theater.Actor;

class JumpMove extends Actor {
	double dist = 25;

	public void setDist(double d) {
		dist = d;
	}

	public void act() {
		jump(dist);
		while (getStage().isInside(getPos())) {
			move(dist);
			jump(dist);
		}
	}
}