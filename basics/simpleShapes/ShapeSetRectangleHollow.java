/*
 * Created on Sep 12, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package simpleShapes;

import mcm.graphics.RectangleShape;
import mcm.theater.*;

public class ShapeSetRectangleHollow extends Actor {

	public void act() {
		setShape(new RectangleShape(100, 20, false));
		while (true) {
			sleep(20);
		}
	}
}