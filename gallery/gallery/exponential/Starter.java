package gallery.exponential;

import java.awt.Color;

import mcm.graphics.EllipseShape;
import mcm.graphics.Point;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.utils.Dice;
import mcm.utils.MCMRuntimeException;

public class Starter extends Actor {

	private int generations = 4; // default number of generations 
	private double legLength = 80; // default movement length of Generators 
	
	public void setGenerations(int i) {
		if (i <= 0) 
			throw new MCMRuntimeException("Generations smaller than zero."); 
		generations = i; 
	}
	
	public void setLegLength(double len) {
		if (len <= 0) 
			throw new MCMRuntimeException("LegLength smaller than zero."); 
		legLength = len; 
	}
	
	// if there is only one actor on the stage, that means this actor is the
	// only one.
	// In that case start two Generators which will multiply like Rabbits in
	// Australia
	// Once there are too many actors kill the Generator Actors on stage
	public void act() {
		setVisible(false);
		while (true) {
		   if (getStage().getNumberOfActors() < 3) {
				sleep(10); // show off the generated pattern before clearing the stage 
				getStage().clear();
				
				// only this actor on stage; need to start Generators
				Color color = Dice.throwColor();
				tracer.printMsg(this, "starting new round nactors="
						+ getStage().getNumberOfActors());

				Point ctr = getStage().getCenter(); 
				startGenerator(ctr, 0, generations, color).start(getStage());
				startGenerator(ctr, 180, generations, color.darker()).start(getStage());
			} else {
				// they are happily producoing right now 
				sleep(10); 
			}
		}
	}

	public Actor startGenerator(Point pos, double angle, int generations, Color color) {
		Actor a = new Generator(legLength, generations);
		int size = getTrailWidth(); 
	
		Shape shape = new EllipseShape(10 + 7 * size, 10 + 7 * size, false);
		shape.setLineWidth(size); 
		shape.setColor(color);
		a.setShape(shape);

		a.setTrailColor(color);
		a.setTrailWidth(size);
		a.setStepSize(getStepSize());
		a.setDirection(angle);
		
		// position
		a.jumpTo(pos);
		a.jump(-40);
		a.left(90); 
		a.jump(5); 
		a.right(90);
		
		return a;
	}
}