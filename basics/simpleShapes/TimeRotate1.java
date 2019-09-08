/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;

import java.awt.Color;

public class TimeRotate1 extends Actor {
	public void act() {
		setDirection(90);
		double size = Math.min(getStage().getWidth(), getStage().getHeight());
		setWidth(size -8);
		setHeight(size -8);
		while (true) {
			right(6);
			sleep(1); // go on after stage advanced clock one tick
		}
	}
}