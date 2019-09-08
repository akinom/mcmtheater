/*
 * Created on Sep 12, 2005
 * 
 * @author Monika Mevenkamp mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.graphics.RectangleShape;
import mcm.theater.*;

public class ShapeHollowSolid extends Actor {

	public void act() {
		RectangleShape shape;
		shape = new RectangleShape(getStage().getWidth() - 10,
				getStage().getHeight() - 10, true);
		setShape(shape);
		setLineWidth(3);
		while (true) {
			shape.setFilled(true);
			sleep(40);
			shape.setFilled(false);
			sleep(40);
		}
	}
}