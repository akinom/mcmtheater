/*
 * Created on Sep 12, 2005
 *
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.graphics.*;
import mcm.theater.*;

public class ShapeSetTriangleHollow extends Actor {
	
	public void act() {
		setShape(new TriangleShape(60, 40, false));
		setLineWidth(3);
		while (true) {
			sleep(20);
		}
	}
}