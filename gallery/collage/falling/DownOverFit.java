/** 
 * move from top to bottom 
 * when reaching bottom reappear at top of stage 
 * choose x,y coordinate ranges so that shape can always fit on stage 
 */
package collage.falling;

import mcm.graphics.EllipseShape;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;

public class DownOverFit extends Actor {
	public DownOverFit() {
		this(new EllipseShape(50, 100, false)); 
		setLineWidth(4);
	}
	
	public DownOverFit(Shape shape) {
		setShape(shape);
	}

	public void act() {
		Stage stage = getStage();

		// this actor makes sure that its position's  x coordinate ranges between 
		//        minx == shape width  and 
		//        maxx == stage width less shape width 
		// so that its shape is always fully show on the stage
		// no matter whether its hot spot mode requires it to be shown towards 
		// the left or right of the actor's position 
		double minX = getWidth();
		double maxX = stage.getWidth() - getWidth();
		// in case shape is wide and stage is skinny 
		if (minX > maxX) {
			minX = stage.getWidth() / 2; 
			maxX = minX; 
		}

		// this actor makes sure that its y coordinate ranges  
		//        from  height + shape height) 
		//        to    - shape height 
		// so that that the shape is always fully shown 
		// no matter whether its hot spot mode requires it to be shown  
		// up- or downwards of the actor's position 
		double minY = -getHeight();
		double maxY = stage.getHeight() - 1 + getHeight();
		// in case shape is height and stage is short 
		if (minY > maxY) {
			minY = stage.getWidth() / 2; 
			maxY = minY; 
		}
		
		// print info to output stream 
		tracer.printMsg(this, "\n" + 
				              "stage: X: 0 - " + stage.getWidth() + "\t" + 
				                     "Y: 0 - " + stage.getHeight() + "\n" + 
				              "       X: " + minX + " - "  + maxX + "\t" +
				                     "Y: " + minY + " - " + maxY); 

		setDirection(-90); // move downwards 
		jumpTo(Dice.throwPoint(getStage())); // start at random point    
		// if too close to left edge jump away from edge 
		if (getPos().x < minX) {
			jumpTo(minX, getPos().y);
		}
		while (true) {
			double newX = getPos().x + 10;
			if (newX >= maxX) {
				newX = minX;
			}
			jumpTo(newX, maxY);

			while (getPos().y > minY) {
				move(getStepSize());
			}

		}
	}
}