/*
 * Created on Sep 12, 2005
 *
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.graphics.ImageShape;
import mcm.theater.*;

public class ShapeSetImage extends Actor {

	public void act() {
		setShape(new ImageShape("simpleShapes/res/butterfly.png", getStage()));
		while (true) {
			sleep(40);
		}
	}
}

