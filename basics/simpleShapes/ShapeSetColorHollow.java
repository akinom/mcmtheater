/*
 * Created on Sep 12, 2005
 *
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import java.awt.Color;

import mcm.graphics.RectangleShape;
import mcm.theater.*;

public class ShapeSetColorHollow extends Actor {
  
  public void act() {
	setShape(new RectangleShape(20, 25, false));
	setColor(Color.BLUE);
    while (true) {
      sleep(40);
    }
  }
}