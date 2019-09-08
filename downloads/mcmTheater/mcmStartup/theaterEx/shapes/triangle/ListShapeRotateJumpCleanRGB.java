/**
 * create a RED, GREEN, and BLUE ShapeRotateCleanJumpNoColor actor
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.theater.*;

public class ListShapeRotateJumpCleanRGB extends Actor {
	public void act() {
		setVisible(false); // this actor is not seen on stage 
		
		// start RED jumper in 0 clock ticks, i.e. immediately
		makeJumper(Color.RED, 0);
		// start GREEN jumper in 10 clock ticks
		makeJumper(Color.GREEN, 10);
		// start BLUE jumper in 20 clock ticks
		makeJumper(Color.BLUE, 20);
	}

	/**
	 * create and start a ShapeRotateCleanJumpNoColor actor 
	 * set its trail width to 2
	 *     its position to the stage's center
	 *     shape to a filled circle with a 9 pixel diameter , 
	 *     shape, trail and shape color to the given color
	 * and start it with the specified delay 
	 */
	public void makeJumper(Color color, int delay) {
		Actor jumper;
		jumper = new ShapeRotateCleanJumpNoColor();
		jumper.setTrailWidth(2);
		jumper.jumpTo(getStage().getCenter());
		jumper.setShape(new EllipseShape(9, 9, true));
		jumper.setColor(color);
		jumper.setTrailColor(color);
		jumper.start(getStage(), delay);
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new ListShapeRotateJumpCleanRGB()); 
	}
}