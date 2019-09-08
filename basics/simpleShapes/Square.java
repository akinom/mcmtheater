/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.theater.*; 

public class Square extends Actor {

/** 
 * draws a square of length 45 
 * 
 * how would you modify the size of the square ?
 * how would you make this actor draw the twice, three times ... ?
 */
	public void act() {
		// this for loop executes the statements inside 4 times (i=0,1,2,3)
		// it follows that this actor performs 4 moves 
		// each followed by a left turn
		for (int i = 0; i < 4; i = i + 1) {
			move(45); 
			left(90); 
		}
	}

}
