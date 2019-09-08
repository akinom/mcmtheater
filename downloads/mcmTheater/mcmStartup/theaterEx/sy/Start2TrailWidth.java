package theaterEx.sy;

import mcm.theater.*;
import mcm.utils.Dice;

public class Start2TrailWidth extends Actor {
	public void act() {
		Actor a;
		
		a = new Rectangle();
		a.setTrailWidth(3);                    // set trail width to 3 pixels
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(60, 40);
		a.start(getStage());

		a = new Rectangle();
		a.setTrailWidth(3);                    // set trail width to 3 pixels 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(120, 100);
		a.start(getStage());
	}
}
