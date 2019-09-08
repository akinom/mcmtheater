package theaterEx.sy;

import mcm.theater.*;
import mcm.utils.Dice;

public class Start5 extends Actor {
	public void act() {
		Actor a;
		
		a = new Rectangle();
		a.setTrailWidth(3); 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(60, 40);
		a.start(getStage());

		a = new Rectangle();
		a.setTrailWidth(3); 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(120, 100);
		a.start(getStage());
		
		a = new Rectangle();
		a.setTrailWidth(3); 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(180, 160);
		a.start(getStage());

		a = new Rectangle();
		a.setTrailWidth(3); 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(240, 220);
		a.start(getStage());

		a = new Rectangle();
		a.setTrailWidth(3); 
		a.setTrailColor(Dice.throwColor());
		a.jumpTo(300, 280);
		a.start(getStage());
	}
}
