/**
 * Actor grows its shapes size from 
 *        (width,height)=(5,5), (6,6), (7,7), ... to (99, 99) 
 *        
 * @author Monika Mevenkamp
 */
package theaterEx.jumpers;

import java.awt.Color;
import mcm.theater.*;

public class OnceGrowShape extends Actor {
	public double size = 100;

	public void act() {
		for (int i = 5; i < size; i++) {
			setWidth(i);
			setHeight(i);
			sleep(1);
		}		
	}
}