package gallery;

import mcm.graphics.*;
import mcm.theater.*;
import mcm.utils.Dice;

public class GrowShapeCloneStarter extends Actor {

	public void act() {
		Stage stage = getStage(); 
		Shape shape; 
		int maxWidth =  (int) (stage.getWidth() + stage.getHeight()) / 4; 
		for (int i = 0; i < 3; i++) {
			GrowShapeAndClone actor;
			if (i % 2 == 0) {
				shape = new EllipseShape(10, 10, true); 	
			} else {
				shape = new RectangleShape(10, 10, true);
			}
			actor = new GrowShapeAndClone(10, maxWidth, maxWidth / 4, shape);
			actor.jumpTo(Dice.throwPoint(getStage()));
			actor.start(stage, Dice.throwInt(30));
		}
	}
}

