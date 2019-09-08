package mcmUser.startup;

import mcm.theater.*;
import mcm.utils.*;
import mcm.graphics.*;
import java.awt.Color;

public class ZigZagStar extends Actor {
	public void act() {
		setTrailWidth(3);
		while (true) {
			for (int i = 0; i < 6; i++) {
				setTrailColor(Dice.throwColor()); 
				zigZag();
				left(60);
			}
			jumpTo(Dice.throwPoint(getStage()));
		}
	}

    // a zig zag move 
	public void zigZag() {
		move(30); 
		right(45); 
		move(30); 
		left(45); 
		// actor now points in the same movement direction 
		// as at the beginning of this zig zag move
	}

	public static void main(String argv[]) {
	   // starts a ne play with a new stage and 
	   // a new ZigZagStar actor as the initial actor
	   Play.main(argv, new ZigZagStar()); 
	}
}
