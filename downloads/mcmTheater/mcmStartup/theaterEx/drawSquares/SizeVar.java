/*
 * Created on Aug 26, 2005
 * @author Monika Mevenkamp 
 *
 * version of the handDrwasSqaure program
 */
package theaterEx.drawSquares;

import mcm.theater.*;
import mcm.utils.Dice;

public class SizeVar extends Actor {
	public void act() {
		double len;
		while (true) {
			   setTrailColor(Dice.throwColor()); 
			   len = 50; square(len); right(180);
			   len = 60; square(len); right(180);
			   len = 70; square(len); right(180);
			   len = 80; square(len); right(180);
			}
	}

	public void square(double size) {
		for (int i = 0; i < 4; i++) {
			move(size);
			right(90);
		}
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new SizeVar());
	}
}
