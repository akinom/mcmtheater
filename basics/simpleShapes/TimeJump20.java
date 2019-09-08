/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.graphics.EllipseShape;
import mcm.theater.*;
import mcm.utils.Dice;

import java.awt.Color;

public class TimeJump20 extends Actor {
	public void act() {
		setShape(new EllipseShape(15, 15, true));
		while (true) {
			jumpTo(Dice.throwPoint(getStage()));
			sleep(20);     // go on after stage advanced clock 20 tick
		}
	}
}