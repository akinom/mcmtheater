/** 
 * The BackAndForth actor forever moves length pixels forward and 
 * either moves or jumps the same distance back
 */
package gallery;

import mcm.theater.Actor;

public class BackAndForth extends Actor {

	double len = 100; 
	boolean doJump = false;
	
	public void setDoJump(boolean b) { doJump = b; }
	public void setLength(double l) { len = l; }
	
	public void act() {
		while (true) {
			move(len);
			if (doJump) {
				jump(-len);
			} else {
				move(-len);
			}
		}
	}

}