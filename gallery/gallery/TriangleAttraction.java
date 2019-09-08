/*
 *
 * 3 Particle actors are put at the corners of a regular triangle. 
 * The Particle Actors move towards the Particle to their left until they 
 * all meet at the center, leaving a trail along their path.
 * 
 * When they are all done 3 new particles are started.
 * 
 * @author: Monika Mevenkamp
 */
package gallery;


import java.awt.Color;

import mcm.theater.*;

public class TriangleAttraction extends Actor {
	public void act() {
		setVisible(false);
		while (true) {
			startThem(getStage(), getStepSize(), getDirection());  // start 3 Particle Actors
			do {
				sleep(10);             // sleep as long as Particles are moving
			} while (getStage().getNumberOfActors() > 1);
			sleep(30);                 // show off the pretty trails
			getStage().clear();        // clear stage and start over
		}
	}

	public static Particle[] startThem(Stage stage, double stp, double angle) {
		Particle a[] = new Particle[3];
		a[0] = new Particle(Color.BLUE, stp);
		a[1] = new Particle(Color.RED, stp);
		a[2] = new Particle(Color.GREEN, stp);
		a[0].setLeader(a[1]);
		a[1].setLeader(a[2]);
		a[2].setLeader(a[0]);
		double len = stage.getWidth();
		if (len > stage.getHeight()) {
			len = stage.getHeight();
		}
		len = 0.9 * len / 2;
		for (int i = 0; i < 3; i++) {
			a[i].setDirection(angle + i * 120);  // direction: 0, 120, 240
			a[i].jumpTo(stage.getCenter());               // jump to center
			a[i].jump(len);                               // jump to triangle's corner
			a[i].start(stage);                            // start
		}
		return a;
	}

}