package simpleShapes;

import mcm.theater.*;

public class MoveJumpBackForth extends Actor {

	double len = 100;

	public void setLength(double l) {
		len = l;
	}

	public void act() {
		while (true) {
			move(len);
			left(180);
			jump(len);
			left(180);
		}
	}

}
