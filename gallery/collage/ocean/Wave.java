/** 
 * moves along a 40 pixel square
 */
package collage.ocean;

import mcm.theater.*;

public class Wave extends Actor
{
    public void act() {
    	setRotatesShape(false); 
		jump(-20);
		while (true) {
			for (int i = 0; i < 4; i++) {
				move(40);
				left(90);
			}
		}
	}

}
