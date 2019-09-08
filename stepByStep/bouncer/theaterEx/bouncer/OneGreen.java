/**
 * @author Monika Mevenkamp 
 * 
 * simple mcmTheater actor 
 */
package theaterEx.bouncer;

import java.awt.Color;

import mcm.graphics.ImageShape;
import mcm.theater.*;
import mcm.theater.actor.*;

public class OneGreen extends Actor {
  
  public void act() {  
    Stage stage = getStage();
    Bouncer b; 
    ImageShape shape; 
    
    b = new Bouncer();
    b.jumpTo(stage.getCenter()); 
    b.setDirection(15);
    shape = new ImageShape("theaterEx/bouncer/res/green.png", getStage());
    b.setShape(shape);
    b.setTrailColor(Color.GREEN); 
    b.start(stage);
  }
  
  public static void main(String argv[]) {
		Play.main(argv, new OneGreen());
	}
}