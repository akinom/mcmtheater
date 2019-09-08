/**
 * Actor grows its shapes size from 
 *        (width,height)=(5,5), (6,6), (7,7), ... to (99, 99) 
 *        
 * @author Monika Mevenkamp
 */
package gallery;

import java.awt.Color;
import mcm.theater.*;

public class OnceGrowShape extends Actor {
	private double startSize = 10; 
	private double stopSize = 10; 

	public void setStartSize(double s) { startSize = s; } 
	public double getStartSize() { return startSize; } 
	public void setStopSize(double s) { stopSize = s; } 
	public double getStopSize() { return stopSize; } 
	
	public void act() {
		for (double size = startSize; size < stopSize; size = size + 2) {
			setWidth(size);
			setHeight(size); 
			sleep(1);
		}
	}
}