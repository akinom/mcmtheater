package galloway.sam;

import mcm.theater.*;
import mcm.theater.actor.*;
import mcm.utils.*;
import mcm.graphics.*;
import java.awt.Color;

// see TryMeStart.hist in mcmUser/drJava
// it contains the commands to start a TryMe actor from DrJava's interactions pane 
public class TryMe extends DrJava {

	public void act() {
		doLooped();
	}

	public void doLooped() {
		setTrailColor(Color.BLUE);
		setTrailWidth(7);
		for (int i = 0; i < 4; i++) {
			doPattern();
			left(90);
		}
	}

	public void doPattern() {
		Actor a = this;
		// DrJava saved history v2
		a.move(20);
		a.left(90);
		a.move(30);
		a.left(90);
		a.move(40);
		a.left(90);
		a.move(50);
		a.left(90);
		a.move(60);
		a.left(90);
		a.move(70);
		a.left(90);
		a.move(80);
		a.left(90);
		a.move(90);
		a.left(90);
		a.move(80);
		a.left(90);
		a.move(20);
		;

	}
}
