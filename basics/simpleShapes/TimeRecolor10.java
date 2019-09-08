package simpleShapes;

import mcm.graphics.RectangleShape;
import mcm.theater.*;
import mcm.utils.Dice;

public class TimeRecolor10 extends Actor {
		public void act() {
			double size = Math.min(getStage().getWidth(), getStage().getHeight());
			setShape(new RectangleShape(size -8, size -8, true)); 
			while (true) {
				setColor(Dice.throwColor());
				sleep(10);   // go on after stage advanced clock 10 tick
			}
		}
}
