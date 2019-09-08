/*
 * Created on Sep 12, 2005
 *
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;

public class ShapeSetSize90_15 extends Actor {

	public void act() {
		setSize(90, 15);
		while (true) {
			sleep(40);
		}
	}
}

