/*
 * Created on Aug 26, 2005
 * @author Monika Mevenkamp 
 *
 * version of the handDrwasSqaure program
 */
package theaterEx.drawSquares;

import mcm.graphics.ImageShape;
import mcm.graphics.Point;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;

public class Image extends Actor {
	public void act() {
		Shape shape = new ImageShape("theaterEx/drawSquares/res/hand.png", getStage());
		shape.setHotSpotPoint(new Point(8, 0));
		setShape(shape); 
		setRotatesShape(false); 
		
		while (true) {
			for (double size = 10; size <= 80; size = size + 10) {
				setTrailColor(Dice.throwColor());
				square(size); right(180);
			}
		}
	}

	public void square(double size) {
		for (int i = 0; i < 4; i++) {
			move(size);
			right(90);
		}
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new Image());
	}
}
