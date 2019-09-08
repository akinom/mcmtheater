/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;
import mcm.utils.Dice;

import java.awt.Color;

public class TimeStageColor extends Actor {
	/**
	 * make a series of Line Actors with different step sizes
	 */
		public void act() {
			setVisible(false);
			while (true) {
				getStage().setColor(Dice.throwColor()); // triggers clearing the stage
				sleep(15);   // go on after stage advanced clock 15 tick
			}
		}
}
