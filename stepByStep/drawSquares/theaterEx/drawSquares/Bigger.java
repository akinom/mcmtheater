/*
 * Created on Aug 26, 2005
 * @author Monika Mevenkamp 
 *
 * version of the handDrwasSqaure program
 */
package theaterEx.drawSquares;

import mcm.theater.*;

public class Bigger extends Actor {
	public void act() {
		square(80); 
	}

	public void square(double size) {
		for (int i = 0; i < 4; i++) {
			move(size);
			right(90);
		}
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new Bigger());
	}
}
