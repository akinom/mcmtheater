package theaterEx.sy;

import mcm.theater.*;
import mcm.utils.Dice;

public class Start2Colored extends Actor {
	public void act() {
		// Dice.throwColor() works like a Dice: 
		//    it randomly chooses among many, many colors, just as the 'real-life' 
		//    Dice chooses randomly bewteen the numbers 1,2,3,4,5, and 6
		Actor a;

		a = new Rectangle();
		a.setTrailColor(Dice.throwColor());  // assign a random color as trail color
		a.jumpTo(60, 40);
		a.start(getStage());

		a = new Rectangle();
		a.setTrailColor(Dice.throwColor());  // assign a random color as trail color
		a.jumpTo(120, 100);
		a.start(getStage());
	}
}