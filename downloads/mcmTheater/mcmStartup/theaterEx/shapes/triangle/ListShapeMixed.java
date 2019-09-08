/**
 * creates a RED ShapeJumpRoate actor and a BLUE ShapeJump actor
 * periodically wipes the stage clean
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;


import mcm.graphics.EllipseShape;
import mcm.theater.*;

public class ListShapeMixed extends Actor {
	public void act() {
		Actor jumper;
		
		jumper = new ShapeJumpRandom(); 
		initializeAndStart(jumper, Color.RED);
		jumper = new ShapeJump(); 
		initializeAndStart(jumper, Color.BLUE);
	
		setVisible(false);
		while (true) {
			sleep(300);
			getStage().clear();
		}
	}
	
	public void initializeAndStart(Actor actor, Color color) 
	{
		actor.setTrailWidth(2);
		actor.setShape(new EllipseShape(7,7,true));
		actor.setTrailColor(color);
		actor.setColor(color);
		actor.start(getStage());
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new ListShapeMixed()); 
	}
}
