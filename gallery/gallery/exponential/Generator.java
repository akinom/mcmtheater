/*
 * Created on Oct 14, 2005
 * 
 * after moving delta pixels forward creates two copies of itself and send them
 * off to the left and right finishes when it falls off the stage's edge
 * 
 * highly dangerous to start because it generates so many new actors which in
 * turn generate lots of new actors
 */
package gallery.exponential;

import mcm.theater.*;

public class Generator extends Actor {
	double delta;
	double angle;
	int generation;
	
	public Generator(double moveLength, int fin) {
		generation = fin;
		delta = moveLength;
		angle = 60 / 0.6;
	}

	public Generator(Generator mom) {
		delta = mom.delta;
		angle = mom.angle;
		generation = mom.generation;
		jumpTo(mom.getPos());
		setShape(mom.getShape());
		setTrailColor(mom.getTrailColor());
		setTrailWidth(mom.getTrailWidth());
		setStepSize(mom.getStepSize());
	}

	public void act() {
		while (generation > 0) {
			move(delta); 
			delta = 0.7 * delta;
			angle = 0.6 * angle; 
			generation = generation - 1;
			
			Generator child;
			child = new Generator(this);
			child.setDirection(getDirection() + angle);
			child.start(getStage());

			child = new Generator(this);
			child.setDirection(getDirection() - angle);
			child.start(getStage());
		}
	}
}

