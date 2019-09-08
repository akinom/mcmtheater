package galloway.alex;

import mcm.theater.*;
import mcm.theater.actor.*;
import mcm.utils.*;
import mcm.graphics.*;
import java.awt.Color;

public class TryMeStarter extends DrJava {
	public void act() {
		TryMe a;
		for (int i = 0; i < 100; i++) {
			a = new TryMe();
			a.setTrailWidth(3);
			a.setShape(new EllipseShape(20, 20, true));
			a.setColor(Dice.throwColor());
			a.setTrailColor(Dice.throwColor());
			a.start(getStage());
		}
	}
}
