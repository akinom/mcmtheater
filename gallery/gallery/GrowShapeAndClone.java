/**
 * GrowShapeAndClone is an actor that sits at its position and grows its shape
 * from size (minWidth, minWidth) to the (maxWidth, maxWidth) sleeping 1 clock
 * tick after each size increase.
 * 
 * The actor schedules a clone of itself to start in waitTicks clock ticks. The
 * actor throws a random number: 0, 1,2,3, or 4 to decide where to position the
 * clone. In 4 out of 5 cases the clone starts at the same position. In 1 out of
 * 5 cases it starts at a random position.
 * 
 * By default GrowShapeAndClone actors grow from size (10, 10) to (210, 210).
 * It starts its clone 40 clock ticks after its own start and uses an ellipse
 * as its shape, see the default constructor GrowShapeAndClone(). 
 *  
 */
package gallery;

import mcm.graphics.*;
import mcm.theater.*;
import mcm.utils.Dice;
import mcm.utils.MCMRuntimeException;

public class GrowShapeAndClone extends Actor {
	private int maxWidth; // maximum shape width

	private int minWidth; // minimum shape width

	private int waitTicks; // number of ticks after which clone of this actor
                           // should start

	public GrowShapeAndClone() {
		this(10, 210, 40, new EllipseShape(10, 10, true));
	}

	public GrowShapeAndClone(int minW, int maxW, int wait, Shape shape) {
		if (minW > maxW) {
			throw new MCMRuntimeException(
					"minWidth must be smaller or equal maxWidth");
		}
		if (wait < 1) {
			throw new MCMRuntimeException("waitTicks must be greater 0");
		}
		maxWidth = maxW;
		minWidth = minW;
		waitTicks = wait;
		
		if (shape == null)
			setShape(new EllipseShape(10, 10, true));
		else {
			 // needs its own copy, not just a reference to somebody else's shape
			setShape(shape.getClone());
		}
	}

	public void act() {
		GrowShapeAndClone clone;
		clone = new GrowShapeAndClone(minWidth, maxWidth, waitTicks, getShape());
		if (Dice.throwInt(5) == 0) {
			clone.jumpTo(Dice.throwPoint(getStage()));
		} else {
			clone.jumpTo(getPos());
		}
		clone.start(getStage(), waitTicks);

		setColor(Dice.throwColor());
		int width = minWidth;
		while (width <= maxWidth) {
			setSize(width, width);
			width = width + 1;
			sleep(1);
		}
		sleep(waitTicks);
	}
}