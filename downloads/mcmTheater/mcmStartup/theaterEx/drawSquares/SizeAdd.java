/*
 * Created on Aug 26, 2005
 * @author Monika Mevenkamp 
 *
 * version of the handDrwasSqaure program
 */
package theaterEx.drawSquares;

import mcm.theater.*;
import mcm.utils.Dice;

public class SizeAdd extends Actor {
	public void act() {
		while (true) {
			setTrailColor(Dice.throwColor());

			double size = 50;
			square(size);right(180);
			size = size + 10;
			square(size);right(180);
			size = size + 10;
			square(size);right(180);
			size = size + 10;
			square(size); right(180);
		}
	}

	public void square(double size) {
		for (int i = 0; i < 4; i++) {
			move(size);
			right(90);
		}
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new SizeAdd());
	}
}