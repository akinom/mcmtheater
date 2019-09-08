/**
 * creates two ShapeRotateCleanJump actors
 * periodically wipes the stage clean
 * 
 * @author Monika Mevenkamp
 */
package theaterEx.shapes.triangle;

import java.awt.Color;

import mcm.theater.*;

public class ListShapeRotateJumpClean extends Actor {
	public void act() {
		makeJumper();
		makeJumper();
		
		setVisible(false);
		while (true) {
			sleep(300);
			getStage().clear();
		}
	}

	public void makeJumper() {
		Actor jumper;

		jumper = new ShapeRotateCleanJump();
		jumper.setTrailWidth(2);
		jumper.jumpTo(getStage().getCenter());
		jumper.start(getStage());
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new ListShapeRotateJumpClean()); 
	}
}
