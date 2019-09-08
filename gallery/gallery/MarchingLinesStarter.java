package gallery;

import mcm.theater.*;
import mcm.utils.Dice;

// starts three MarchingLines actors with shapes that are 
// a quarter of the stage wide and a third of the stage high.
// One actor moves horizontally on the center line from left to right. 
// The other two move above/below the middle actor from right to left. 
// Actors are started to the left/right of the stage's sides so their shapes
// move smoothly into the stage area. Note that the stage's mode is set to LEAVE. 
//
// MarchingLines actors have a color property that they use to color their 
// own shape and to tell their clones how to modify the shape color
//
public class MarchingLinesStarter extends Actor {
	
	public void act() {
		Stage stage = getStage();
		stage.setMode(Stage.LEAVE);
		double width = stage.getWidth() / 4;
		double height = stage.getHeight() / 3;
		double middle = stage.getHeight() / 2;
        
		MarchingLines a;
		a = new MarchingLines(width, height, width);
		a.setColor(Dice.throwColor());
		a.setDirection(0);
		a.jumpTo(-width, middle);
		a.start(stage);
		
		a = new MarchingLines(width, height, width);
		a.setDirection(180);
		a.setColor(Dice.throwColor());
		a.jumpTo(stage.getWidth() - 1 + width, middle + height);
		a.start(stage);

		a = new MarchingLines(width, height, width);
		a.setDirection(180);
		a.setColor(Dice.throwColor());
		a.jumpTo(stage.getWidth() - 1 + width, middle - height);
		a.start(stage);
	}
	
    public static void main(String argv[]) {
    	Play.main(argv, new MarchingLinesStarter()); 
    }

}