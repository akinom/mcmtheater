
package gallery;

import java.awt.Color;
import mcm.graphics.*;
import mcm.theater.*;
import mcm.theater.actor.ShowShape;

public class DirIsFct extends Actor {

	public void act() {
		DirIsFctActor a = new DirIsSin();
		a.setColor(Color.YELLOW); 
		a.setTrailColor(Color.YELLOW.darker()); 
		a.jumpTo(getStage().getWidth() / 2, 3 * getStage().getHeight() / 5);
		a.start(getStage()); 	
		
		a = new DirIsSin2();
		a.setColor(Color.RED); 
		a.setTrailColor(Color.RED.darker()); 
		a.jumpTo(getStage().getWidth() / 2, 2 * getStage().getHeight() / 5);
		a.start(getStage()); 	
		
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new DirIsFct());
	}
}

abstract class DirIsFctActor extends Actor {

	protected abstract double applyFct(double x);
	
	public void act() {
		double x0 = getPosX(); 
		double y0 = getPosY(); 
		double scalex = 3 * Math.PI / 180; 

		Color color = getColor(); 
		TextShape angleText = new TextShape("", getStage()); 
		angleText.setHotSpot(Shape.LOWER_LEFT); 
		angleText.setColor(color); 
		
		TextShape labelText = new TextShape(toString(), getStage());  
		labelText.setHotSpot(Shape.LOWER_RIGHT); 
		labelText.setColor(getTrailColor()); 
		
		RectangleShape angleStick = new RectangleShape(100, 2 * getTrailWidth(), true);
		angleStick.setHotSpot(Shape.LOWER_LEFT); 
		angleStick.setColor(color);
		
		Actor showLabel = new ShowShape(); 
		showLabel.setShape(labelText); 
		showLabel.start(getStage()); 
		
		Actor showAngle = new ShowShape(); 
		showAngle.setShape(angleText); 
		showAngle.start(getStage()); 
		
		Actor showFct = new ShowShape(); 
		showFct.setShape(angleStick); 
		showFct.setTrailWidth(2);
		showFct.setTrailColor(getTrailColor());
		showFct.start(getStage()); 
		
		setShape(angleStick);
		setTrailWidth(2);
		setTrailColor(color);

		showLabel.jumpTo(getStage().getWidth()-1, y0); 
		
		showFct.jumpTo(x0, y0); 
		showFct.lineTo(getStage().getWidth(), y0); 
		showFct.jumpTo(x0, y0);
		jumpTo(x0, y0); 
		
		double x = 0; 
		while (getStage().getWidth()  >= showFct.getPosX()) {		 
			double dir = applyFct(x); 
	
		     angleText.setText("" + (int) dir);
		     showAngle.jumpTo(x0 + x / scalex, y0 + dir); 
		     showFct.setDirection(dir); 	
		     showFct.lineTo(x0 + x / scalex, y0 + dir); 
		     
		     setDirection(dir); 
		     move(3); 
		     
		     x = x + scalex;
		     sleep(6);
		}
		
		showAngle.terminate();
		showFct.terminate();
		
	}
}

class DirIsSin extends DirIsFctActor
{
	public String toString() {
		return "180 * sin(x)"; 
	}
	
	protected double applyFct(double x) 
	{
		double y = 180 * Math.sin(x); 
	     return y;
	}
}

class DirIsSin2 extends DirIsFctActor
{
	public String toString() {
		return "180 * sin(2x)"; 
	}
	
	protected double applyFct(double x) 
	{
		double y = 180 * Math.sin(2 * x); 
	     return y;
	}
}
