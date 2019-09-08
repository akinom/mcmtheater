package gallery;

import java.awt.Color;

import mcm.graphics.Point;
import mcm.graphics.RectangleShape;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;

public class MarchingLines extends Actor {
    double width;
    double height;
    double distance;
    ColorComputer colorComp; 
    
    public MarchingLines() 
    {
    	this(55, 50, 55);
    	setDirection(0); 
    }
    
	public MarchingLines(double shapeWidth, double shapeHeight, double moveDist) 
	{
		width = shapeWidth; 
		height = shapeHeight;
		colorComp = new ColorComputer(getTrailColor());  
		distance = moveDist;
	}
	
	public void setColor(ColorComputer col) 
	{
		colorComp = col;
	}
	
	public void setColor(Color col) 
	{
		colorComp = new ColorComputer(col);
	}
	
	public void act() {
		tracer.traceMsg(this, "start distance=" + distance + " color=" + colorComp.color); 
		
		// use a filled rectangke shape width by height pixels in the trail color 
		Shape shape = new RectangleShape(width, height, true); 
		shape.setColor(colorComp.getColor()); 
		setShape(shape);

		// make trail invisible 
		setTrailVisible(false);
		
		Point startPos = getPos(); // remember position to create clone there 
		move(distance);            // move distance before creating clone
		
		// make and start a clone 
		// 1 out of 10 cases color is reset to a random color 
		// 9 out of 10 cases color is moved to the net color 
		if (Dice.throwInt(10) == 0) {
			colorComp = new ColorComputer(Dice.throwColor()); 
		} else {
		    colorComp.modify(); 
		}
		MarchingLines clone;
		clone = new MarchingLines(width, height, distance);  // clone has same with same width, height, and distance 
		clone.jumpTo(startPos);                    // clone jumps to this actor's starting position 
		clone.setDirection(getDirection());        //       moves in same direction as this actor
		clone.setStepSize(getStepSize());          //       moves with same speed
		clone.setColor(colorComp);                 //       uses smae color as this actor 
		clone.start(getStage());                   //       starts immediately
	
		while (getStage().isInside(getPos())) {    // thsi actor moves until leaving stage 
			move(distance);              
		}
		move(distance);  // move width to make sure shape completely leaves from stage
	}
	
	// helper class to compute related colors 
	class ColorComputer {  
		private int delta;
		private Color color; 
		
		ColorComputer(Color c) {
			color = new Color(c.getRed(), c.getGreen(), c.getBlue()); 
			delta = 16;
		}

		ColorComputer(ColorComputer c) {
			color = new Color(c.color.getRed(), c.color.getGreen(), c.color.getBlue()); 
			delta = c.delta;
		}

		Color getColor() 
		{
			return color; 
		}

		// modifies this Colores' color 
		// the modified color differs from the previous one in only one of it's of its rgb values
		void modify() {		
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();

			if (blue + delta < 256 && blue + delta >= 0) {
				blue = blue + delta;
			} else {
				if (green + delta < 256 && green + delta >= 0) {
					green = green + delta;
				} else {
					if (red + delta < 256 && red + delta >= 0) {
						red = red + delta;
					} else {
						delta = -1 * delta;
						modify();
					}
				}
			}
			color = new Color(red, green, blue);
		}
	}
}
