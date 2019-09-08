package collage.falling;

import java.awt.Color;

import mcm.graphics.ImageShape;
import mcm.graphics.Shape;
import mcm.theater.*;

public class LeafsDownOver extends Actor {

	public void act() {
		Shape shape;
		getStage().setMode(Stage.LEAVE);
		Actor down; 
		
		shape = new ImageShape("collage/res/leafs/silver_maple_leaf_middle.png", getStage());
		shape.setHotSpot(ImageShape.LOWER_RIGHT);
		down = new DownOver(shape); 
		down.setTrailColor(Color.GREEN);
		down.setStepSize(1.5);
		down.start(getStage()); 
		
		shape = new ImageShape("collage/res/leafs/red_maple_leaf_small.png", getStage());
		shape.setHotSpot(ImageShape.UPPER_RIGHT);
		down = new DownOver(shape); 
		down.setTrailColor(Color.ORANGE);
		down.setStepSize(1.75);
		down.start(getStage()); 

		shape = new ImageShape("collage/res/leafs/silver_maple_leaf_small.png", getStage());
		shape.setHotSpot(ImageShape.UPPER_RIGHT);
		down = new DownOver(shape); 
		down.setTrailColor(Color.YELLOW);
		down.setStepSize(2.5); 
		down.start(getStage()); 

		shape = new ImageShape("collage/res/leafs/red_maple_leaf_tiny.png", getStage());
		shape.setHotSpot(ImageShape.LOWER_LEFT);
		down = new DownOver(shape); 
		down.setTrailColor(Color.RED);
		down.setStepSize(3.5); 
		down.start(getStage()); 
	
		setVisible(false); 
		while (true) {
			sleep(1200); 
			getStage().clear(); 
		}
	}

}