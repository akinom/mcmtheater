/*
 * Created on Sep 12, 2005
 *
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import java.awt.Color;
import mcm.graphics.*;
import mcm.theater.*;

public class ShapeSetTriangleSolid extends Actor {
	
	public void act() {
		setShape(new TriangleShape(-40, 25, 0, -25, 40, 0, true));
		setColor(Color.GREEN); 
		while (true) {
			sleep(20);
		}
	}
}