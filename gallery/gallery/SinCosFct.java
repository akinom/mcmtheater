package gallery;

import java.awt.Color;
import mcm.graphics.*;
import mcm.theater.*;
import mcm.utils.Dice;

public class SinCosFct extends Actor {
	/**
	 * This actor starts 3 SinCos actors that follow different sin/cos curves.
	 * It adds the three curves together and follows the path off the fct
	 * defined as (x, curve0(x) + curve1(x) + curve(3))
	 */
	public void act() {

		while (true) {
			getStage().clear();

			SinCos curve[] = new SinCos[3];

			curve[0] = new SinCos(getStage(), Color.BLUE, false); // yellow cosine curve
			curve[0].setScalex(0.5 + Dice.throwDouble(1));
			curve[0].setAmplitude(40 + Dice.throwDouble(60));
			curve[0].start(getStage());

			curve[1] = new SinCos(getStage(), Color.GREEN, false); // hteen cosine curve 
			curve[1].setScalex(1 + Dice.throwInt(1));
			curve[1].setAmplitude(40 + Dice.throwDouble(20));
			curve[1].start(getStage());

			curve[2] = new SinCos(getStage(), Color.MAGENTA, true); // cyan sine curve 
			curve[2].setScalex(2 + Dice.throwDouble(1));
			curve[2].setAmplitude(30 + Dice.throwDouble(15));
			curve[2].start(getStage());

			setTrailWidth(2);
			setShape(new RectangleShape(2 * getTrailWidth(), 2 * getStage()
					.getHeight(), true));
			double y0 = getStage().getHeight() / 2;
			jumpTo(0, y0);
			lineTo(getStage().getWidth(), y0);
			jumpTo(0, y0);
			sleep(1); // make sure this actor lags 1 time step after the sin/cos actors 
			while (getStage().isInside(curve[0].getPos())) {
				double x = curve[0].getPosX();
				double y = curve[0].getPosY() + curve[1].getPosY()
						+ curve[2].getPosY() - 2 * y0;
				lineTo(x, y);
				sleep(2);
			}

		}

	}

	public static void main(String argv[]) {
		Play.main(argv, new SinCosFct());
	}
}

class SinCos extends Actor {
	/**
	 * This actor moves along the path of a sin or cos curve centered on the
	 * stage's horizontal midline. If it follows the sin curve it starts at
	 * position (0, a*sin(0)) and moves on to (1,a*sin(scalex)), (2,
	 * a*sin(2*sx)), ... (x, a*sin(x*sx)), ... where a is the curve's amplitude
	 * and sx denotes the number of degrees that 1 pixel on the screen should
	 * reperesents. If the actor follows a cosine curve it replaces all sin fct
	 * calls in its computations.
	 */
	boolean sin; // whether to compute sin or cos

	double scalex; // the degree (in radians) that 1 pixel represents 

	double amplitude; // amplitude of sin/cos fct 

	SinCos(Stage stage, Color color, boolean isSin) {
		sin = isSin;
		setScalex(1);
		setAmplitude(stage.getHeight() / 3);
		setTrailColor(color);
		setColor(color);
		setVisible(false);
	}

	// sets the amplitype of the sin/cos curve
	void setAmplitude(double a) {
		amplitude = a;
	}

	// sets scalex so that one pixel correponds to the given number of degrees in radians
	void setScalex(double degree) {
		scalex = degree * Math.PI / 180;
	}

	private double function(double x) {
		if (sin) {
			return amplitude * Math.sin(scalex * x);
		} else {
			return amplitude * Math.cos(scalex * x);
		}
	}

	public void act() {
		double x = 0;
		double y = function(x);
		double y0 = getStage().getHeight() / 2;
		jumpTo(x, y0 + y);

		while (getStage().isInside(getPosX(), getPosY())) {
			y = function(x);
			lineTo(x, y0 + y);
			sleep(2);
			x++;
		}

	}
}

