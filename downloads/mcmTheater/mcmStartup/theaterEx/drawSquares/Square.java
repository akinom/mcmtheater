/*
 * Created on Aug 26, 2005
 * @author Monika Mevenkamp 
 *
 * version of the handDrwasSqaure program
 */
package theaterEx.drawSquares;

import mcm.theater.*;

public class Square extends Actor {
	public void act() {
		// call square for a size of 50
		square(50); 
	}

	public void square(double size) {
		// execute the statements inside the for loop 4 times 
		// everything between the curly braces {} is considered to be inside
		for (int i = 0; i < 4; i++) {
			move(size);
			right(90);
		}
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new Square());
	}
}
