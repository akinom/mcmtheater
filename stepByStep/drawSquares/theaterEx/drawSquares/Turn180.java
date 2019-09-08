/*
 * Created on Aug 26, 2005
 * @author Monika Mevenkamp 
 *
 * version of the handDrwasSqaure program
 */
package theaterEx.drawSquares;

import mcm.theater.*;
import mcm.utils.Dice;

public class Turn180 extends Actor {
	public void act() {
		while (true) {
			setTrailColor(Dice.throwColor());
			square(80); 
			right(180);
		}
	}

	public void square(double size) {
		for (int i = 0; i < 4; i++) {
			move(size);
			right(90);
		}
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new Turn180());
	}
}
