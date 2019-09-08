package gallery;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.graphics.Point;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;

public class ShootLines extends Actor {
	
	double maxAngle;

	double deltaAngle;

	double lineLength;

	int wait;

	public ShootLines() {
		this(100, 105, 15, 5);
	}

	public ShootLines(double len, double max, double dAngle, int w) {
		maxAngle = max;
		deltaAngle = dAngle;
		lineLength = len;
		wait = w;
	}

	public void act() {
		setVisible(false);
		double width = getWidth();
		Point pos = getPos();
		
		while (true) {
			double myDir = getDirection();
			Shape shape = new EllipseShape(width, width, true);
			shape.setColor(Dice.throwColor());
			for (double a = 0; a < maxAngle; a = a + deltaAngle) {
				Actor line = new Line(lineLength);
				line.setDirection(myDir + a);
				line.jumpTo(pos);
				line.setTrailVisible(false);
				line.setShape(shape);
				line.start(getStage());
			}
			sleep(wait);
			left(deltaAngle);
		}
	}

	class Line extends Actor {
		double lineLength;

		public Line(double len) {
			lineLength = len;
		}

		public void act() {
			if (lineLength < 0) {
				while (getStage().isInside(getPos())) {		
					move(getStepSize());
				}
			} else {
				move(lineLength);
			}
		}
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new ShootLines(200, 105, 15, 5)); 
	}

}

