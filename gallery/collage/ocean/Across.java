/** 
 * move horizontally across the stage 
 * when reaching right edge reappear at left edge of stage 
 */
package collage.ocean;

import mcm.theater.*;
import mcm.utils.Dice;

public class Across extends Actor {

	public void act() {
		Stage stage = getStage();
		setDirection(0); // move to the right
		while (true) {
			double lastx = stage.getWidth() + getWidth();
			while (getPos().x < lastx) {
				move(getStepSize());
			}
			sleep(Dice.throwInt(20));
			jumpTo(0, getPos().y);
		}
	}
}