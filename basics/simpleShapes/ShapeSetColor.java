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

public class ShapeSetColor extends Actor {
  
  public void act() {
	setShape(new RectangleShape(20, 25, true));
	setColor(Color.BLUE);
    while (true) {
      sleep(40);
    }
  }
}