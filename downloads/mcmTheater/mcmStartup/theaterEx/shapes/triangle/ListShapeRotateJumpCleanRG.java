/**
 * create a GREEN and RED ShapeRotateCleanJumpNoColor actor
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.theater.*;

public class ListShapeRotateJumpCleanRG extends Actor {
	public void act() {
		makeJumper(Color.GREEN);
		makeJumper(Color.RED);		
	}

	/**
	 * create and start a ShapeRotateCleanJumpNoColor actor 
	 * set its trail width to 2
	 *     its position to the stage's center
	 *     shape to a filled circle with a 9 pixel diameter , 
	 *     shape, trail and shape color to the given color
	 * and start it 
	 */
	public void makeJumper(Color color) 
	{
		Actor jumper;	
		jumper = new ShapeRotateCleanJumpNoColor(); 
		jumper.setTrailWidth(2);
		jumper.jumpTo(getStage().getCenter());
		jumper.setShape(new EllipseShape(9, 9, true));
		jumper.setColor(color);
		jumper.setTrailColor(color);
		jumper.start(getStage());
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new ListShapeRotateJumpCleanRG()); 
	}
}
