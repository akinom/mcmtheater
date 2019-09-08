/**
 * @author Monika Mevenkamp 
 * 
 * simple mcmTheater actor 
 */
package theaterEx.bouncer;

import java.awt.Color;

import mcm.theater.*;
import mcm.theater.actor.*;

public class OneBounce extends Actor {
   
   public void act() { 
      Stage stage = getStage();
      Bouncer b = new Bouncer();
      b.jumpTo(stage.getCenter()); 
      b.setDirection(15);
      b.start(stage);
   }
   
   public static void main(String argv[]) {
		Play.main(argv, new OneBounce());
	}
}