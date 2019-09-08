package gallery;

import mcm.graphics.RectangleShape;
import mcm.theater.*;
import mcm.utils.Dice;

import java.awt.Color;

public class RectangleJumper extends Actor {

	private double rectWidth;

	private double rectHeight;

	public RectangleJumper() {
		setVisible(false);
		rectWidth = 0;
		rectHeight = 0;
	}

	public RectangleJumper(int w, int h) {
		setVisible(false);
		rectWidth = w;
		rectHeight = h;
	}

	public void act() {
		init();
		while (true) {
			// draw series of rectangles 
			double w = rectWidth;
			double h = rectHeight;
			int delta = (int) (Math.min(w, h) * 0.2);
			if (delta < 3)
				delta = 3;
			while (w > 5 && h > 5) {
				setColor(Dice.throwColor());
				rectangle(w, h);
				w = w - delta;
				h = h - delta;
			}
			sleep(10);
			jumpToNeighbor(0);
		}
	}

	// draw a colored rectangle centered around current position 
	// with given width and height 
	void rectangle(double width, double height) {
		setWidth(width);
		setHeight(height);
		stamp();
	}

	void jumpToNeighbor(int n) {
		// jump to new position either above, left, right, or below the 
		// current position, so that the next set of rectangles will fit 
		// right next to the last one, which was drawn centered around this
		// position
		// the distance between the centers of rectangles is 
		//    horizontally: rectWidth 
		//    vertically: rectHeight
		boolean jumped = false;
		double dist;
		while (!jumped) {
			// choose 0, 90, 180, or 360 degrees for new movement direction 
			int dir = 90 * Dice.throwInt(4);
			left(dir);
			if (getDirection() % 180 == 0) {
				// a horizontal move to the left or right
				dist = rectWidth + 1;
			} else {
				// a vertical move
				dist = rectHeight + 1;
			}
			jump(dist);

			// now actor is at the new center
			if (getStage().isInside(getPos())) {
				// the new position is still inside the stage
				jumped = true;
			} else {
				// ouside stage; jump back to the old position and try again
				jump(-dist);
			}
			// return to previous movement direction
			right(dir);

			// if jump was successful actor will leave this loop 
		}
		
		// in one out of three cases wipe current position out with a rectangle in stage color 
		// and jump  again
		// do this at most once, i.e. if n = 0; 
		if (n == 0 && Dice.throwInt(3) == 0) {
			// black out and jump again
			setColor(getStage().getColor());
			rectangle(rectWidth+0.5, rectHeight+0.5);
			jumpToNeighbor(n + 1); // next time don't wipe clean 
		}
	}

	void init() {
		if (rectHeight <= 0) {
			// assuming a height of 120, how many rectangles fit ? 
			int n = 1;
			for (n = 9; n > 1; n = n - 2) {
				if (getStage().getHeight() / n > 10)
					break;
			}
			rectHeight = getStage().getHeight() / n;
			tracer.println("n=" + n + " height=" + rectHeight);
		}

		if (rectWidth <= 0) {
			// assuming a height of 120, how many rectangles fit ? 
			int n = 1;
			for (n = 9; n > 1; n = n - 2) {
				if (getStage().getWidth() / n > 10)
					break;
			}
			rectWidth = getStage().getWidth() / n;
			tracer.println("n=" + n + " width=" + rectWidth);
		}

		setShape(new RectangleShape(rectWidth, rectHeight, true));
		tracer.println(this + ": width/height=" + rectWidth + " " + rectHeight);
		tracer.println("Stage" + ": width/height=" + getStage().getWidth()
				+ " " + getStage().getHeight());
	}

	public static void main(String argv[]) {
		Play.main(argv, new RectangleJumper()); 
	}
}

