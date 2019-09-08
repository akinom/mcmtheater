/** 
 * move from top to bottom 
 * when reaching bottom reappear at top of stage 
 */
package collage.falling;

import mcm.theater.*;

public class Down extends Actor {

	public void act() {
		Stage stage = getStage();
		setDirection(-90); // move downwards 
		while (true) {
			while (getPos().y > 0) {
				move(getStepSize());
			}
			jumpTo(getPos().x, stage.getHeight() -1); 
		}
	}
}