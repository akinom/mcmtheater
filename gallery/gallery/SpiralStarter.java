/**
 * create 4 Spiral Actors that are arranged in a 2 by 2 grid on the stage Each
 * Spiral Actor draws a spiral path and creates a copy of itself that follows
 * sometime later in a different color, erasing its predecessor's trail. Spiral
 * Actors finish when their spiral reaches a maximum side length.
 */
package gallery;

import mcm.graphics.Point;
import mcm.theater.*;
import mcm.theater.actor.*;

public class SpiralStarter extends Actor {

	int deltaDiv;

	boolean forever;

	public SpiralStarter(int deltaD, boolean loop) {
		deltaDiv = deltaD;
		forever = loop;
	}

	public SpiralStarter() {
		this(18, true);
	}

	public void act() {
		/*
		 * create 4 Spiral Actors and arranges in a centered 2 by 2 grid The
		 * bigger the stage the bigger the Spiral's maximum side length and the
		 * longer the time difference between Spirals creating copies of
		 * themselves.
		 * 
		 * This  actor dies after setup
		 */
		Point ctr = getStage().getCenter();
		Actor a;

		int maxLength = (int) (getStage().getHeight() / 2.1);
		int delta = maxLength / deltaDiv;
		if (delta < 2) {
			delta = 2;
		}
		maxLength = deltaDiv * delta;
		int offset = maxLength / 2 + delta;
		int delay = (int) (maxLength / getStepSize() * 2);
		if (delay == 0) {
			delay = 4;
		} else {
			Eraser ea = new Eraser(4 * delay / 3);
			ea.start(getStage());
		}

		tracer.printMsg(getStage(), "starting new set of spirals with maxLength=" + maxLength);
		a = makeSpiralActor(maxLength, delta, delay, ctr.x - offset, ctr.y
				- offset);
		a.start(getStage());
		a = makeSpiralActor(maxLength, delta, delay, ctr.x + offset, ctr.y
				- offset);
		a.start(getStage(), 0);
		a = makeSpiralActor(maxLength, delta, delay, ctr.x - offset, ctr.y
				+ offset);
		a.start(getStage(), 0);
		a = makeSpiralActor(maxLength, delta, delay, ctr.x + offset, ctr.y
				+ offset);
		a.start(getStage());
	}

	Actor makeSpiralActor(int max, int deltaLen, int delay, double x, double y) {
		Actor a = new Spiral(deltaLen, max, deltaLen, delay);
		a.jumpTo(x, y);
		a.setVisible(false);
		a.setTrailWidth((int) (1.7 * deltaLen));
		a.setStepSize(getStepSize());

		return a;
	}

	public static void main(String argv[]) {
		Play.main(argv, new SpiralStarter());
	}

}

