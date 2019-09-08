/**
 * forever jumps to a randomly chosen spot on the stage, and draws a triangle
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;

public class ShapeCtrLineMCG extends Actor {
	public void act() {
		makeShapeLine(45, Color.CYAN);
		makeShapeLine(45, Color.GREEN);
		makeShapeLine(135, Color.MAGENTA);
	}

	void makeShapeLine(int angle, Color color) {
		ShapeCtrLineJump actor = new ShapeCtrLineJump();
		actor.setDirection(angle);
		actor.setTrailColor(color);
		actor.setVisible(false);
		actor.setStepSize(100);
		actor.setTrailWidth(2);
		actor.start(getStage());
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new ShapeCtrLineMCG()); 
	}
}

