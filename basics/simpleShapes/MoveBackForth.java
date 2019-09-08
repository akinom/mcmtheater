package simpleShapes;

import mcm.theater.Actor;

public class MoveBackForth extends Actor {

	double len = 100; 
	
	public void setLength(double l) { len = l; }
	
	public void act() {
		while (true) {
			move(len);
			left(180);
		}
	}

}
