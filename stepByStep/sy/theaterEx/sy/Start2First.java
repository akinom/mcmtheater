
package theaterEx.sy;

import mcm.theater.*;

public class Start2First extends Actor {
	public void act() {
		Actor a;

		a = new Rectangle();  // create a Rectangle actor instead of ShowShape
		a.jumpTo(10, 20);
		a.start(getStage());

		a = new Rectangle();  // create a Rectangle actor instead of ShowShape
		a.jumpTo(30, 40);
		a.start(getStage());
	}
}
