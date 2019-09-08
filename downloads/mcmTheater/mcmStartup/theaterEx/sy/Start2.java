package theaterEx.sy;

import mcm.theater.*;

public class Start2 extends Actor {
	public void act() {
		Actor a;

		a = new Rectangle();
		a.jumpTo(60, 40);        // position at (60, 40)
		a.start(getStage());

		a = new Rectangle();
		a.jumpTo(120, 100);      // position at (120, 100)
		a.start(getStage());
	}
}
