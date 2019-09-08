/** 
 * move from top to bottom 
 * when reaching bottom reappear at top of stage 
 */
package collage.falling;

import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;

public class DownOver extends Actor {
	public DownOver() 
	{
		this(new EllipseShape(50, 100, false)); 
		setLineWidth(4);
	}
	public DownOver(Shape shape) {
		setShape(shape);
	}

	public void act() {
		Stage stage = getStage();
		setDirection(-90); // move downwards 
		jumpTo(Dice.throwPoint(getStage())); // start at random position 
		
		while (true) {
			while (getPos().y > 0) {
				move(getStepSize());
			}
			double newX = getPos().x + 10; 
			if (newX >= stage.getWidth()) {
				newX = 5;
			}
			jumpTo(newX, stage.getHeight() -1); 
		}
	}
}