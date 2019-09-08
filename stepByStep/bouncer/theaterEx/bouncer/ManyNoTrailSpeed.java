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
import mcm.utils.Dice;

public class ManyNoTrailSpeed extends Actor {

	public void act() {
		for (int i = 1; i <= 10; i = i + 1) {
			makeGreenYellow();
		}
	}

	public void makeGreenYellow() {
		Stage stage = getStage();
		Bouncer b;
		ImageShape shape;

		b = new Bouncer();
		b.jumpTo(Dice.throwPoint(stage));
		b.setDirection(Dice.throwInt(360));
		shape = new ImageShape("theaterEx/bouncer/res/green.png", getStage());
		b.setShape(shape);
		b.setTrailVisible(false);
		b.setDebugMode(true);
		b.setStepSize(Dice.throwDouble(0.5, 5.0)); 
		b.start(stage);

		b = new Bouncer();
		b.jumpTo(Dice.throwPoint(stage));
		b.setDirection(Dice.throwInt(360));
		shape = new ImageShape("theaterEx/bouncer/res/yellow.png", getStage());
		b.setShape(shape);
		b.setTrailVisible(false);
		b.setDebugMode(true);
		b.setStepSize(Dice.throwDouble(0.5, 5.0)); 
		b.start(stage);
	}
	
	public static void main(String argv[]) {
		Play.main(argv, new ManyNoTrailSpeed());
	}
}