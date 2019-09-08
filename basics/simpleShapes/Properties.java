/**
 * @author Monika Mevenkamp
 * mini example to show mcmTheater feature
 */
package simpleShapes;

import mcm.graphics.*;
import mcm.theater.*;

import java.awt.Color;

public class Properties extends Actor {
	/**
	 * start a series square drawing actors 
	 * with differnt line, shape, color, and speed properties
	 */
	static double delta = 21;  // distance between Squares
	static double len = 45;    // side length of squares

	public void act() {

		setVisible(false);
		CenteredSquare[] a = new CenteredSquare[10];
		for (int i = 0; i < 10; i++) {
			a[i] = new CenteredSquare();
		}

		int ai = 0; 
		DirectionShape shape;
		
		shape = (DirectionShape) a[ai].getShape(); 
		shape.setFilled(false);
		a[ai].setStepSize(1); 
		a[ai].setTrailColor(Color.RED);
		a[ai].setTrailVisible(true);
		a[ai].setTrailWidth(1);
		a[ai].setDirection(45);
		a[ai].setVisible(true);
		ai++;

		a[ai].setStepSize(1); 
		a[ai].setTrailColor(Color.ORANGE);
		a[ai].setTrailVisible(true);
		a[ai].setShape(new TriangleShape(getHeight(), getWidth(), true));
		a[ai].setColor(Color.ORANGE);
		a[ai].setTrailWidth(1);
		a[ai].setVisible(true);
		ai++;

		a[ai].setStepSize(1); 
		a[ai].setTrailColor(Color.GREEN);
		a[ai].setShape(new RectangleShape(getHeight(), getWidth(), false));
		a[ai].setColor(Color.GREEN);
		a[ai].setTrailVisible(true);
		a[ai].setTrailWidth(1);
		a[ai].setVisible(true);
		ai++;

		a[ai].setStepSize(1); 
		a[ai].setTrailColor(Color.GREEN);
		a[ai].setTrailVisible(true);
		a[ai].setTrailWidth(3);
		a[ai].setVisible(true);
		ai++;

		a[ai].setStepSize(3); 
		a[ai].setTrailColor(Color.BLUE);
		a[ai].setTrailVisible(true);
		a[ai].setTrailWidth(3);
		a[ai].setVisible(false);
		ai++;
		
		a[ai].setStepSize(3);
		a[ai].setColor(Color.RED);
		a[ai].setTrailColor(Color.RED);
		a[ai].setTrailVisible(false);
		a[ai].setTrailWidth(1);
		a[ai].setVisible(true);
		ai++;

		a[ai].setStepSize(3); 
		a[ai].setShape(new RectangleShape(22, 11, false));
		a[ai].setColor(Color.GREEN);
		a[ai].setTrailColor(Color.GREEN);
		a[ai].setTrailVisible(false);
		a[ai].setTrailWidth(1);
		a[ai].setVisible(true);
		ai++;

		a[ai].setStepSize(3); 
		a[ai].setShape(new EllipseShape(11, 22, true));
		a[ai].setColor(Color.ORANGE);
		a[ai].setTrailColor(Color.ORANGE);
		a[ai].setTrailVisible(false);
		a[ai].setTrailWidth(1);
		a[ai].setVisible(true);
		ai++;

		a[ai].setStepSize(3); 
		a[ai].setShape(new ImageShape("simpleShapes/res/butterfly.png", getStage()));
		a[ai].setTrailColor(Color.RED);
		a[ai].setTrailVisible(false);
		a[ai].setTrailWidth(1);
		a[ai].setDirection(45);
		a[ai].setVisible(true);
		ai++;

		Point pos = new Point(delta + len / 2, getStage().getCenter().y);
		for (int i = 0; i < ai; i++) {
			a[i].jumpTo(pos);
			a[i].setLength(len);
			tracer.printMsg(a[i], "pos=" + a[i].getPos()); 
			pos.x += delta + len;
			a[i].start(getStage()); 
		}

		while (true) {
			sleep((int) (8 * len) );
			getStage().clear();
		}
		
	}
}