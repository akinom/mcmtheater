/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;
import java.awt.Color;

public class Star extends Actor {
	/**
	 * turn each time before drawing a rectangle
	 */
	public void act() {
		while (true) {
			for (int i = 0; i < 4; i++) {
				move(15);
				left(45);
				move(25);
				right(90);
				move(25);
				left(45);
				move(15);

				right(90);
			}

			left(15);
		}

	}

}
