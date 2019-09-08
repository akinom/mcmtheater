/*
 * Created on Sep 12, 2005
 *
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*;

public class ShapeSetSize30_30 extends Actor {

	public void act() {
		setSize(30, 30);
		while (true) {
			sleep(40);
		}
	}
}

