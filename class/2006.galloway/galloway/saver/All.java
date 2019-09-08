/*
 * Created on Nov 3, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package galloway.saver;

import mcm.graphics.TextShape;
import mcm.theater.*;
import java.awt.Color; 
import mcm.graphics.*;

public class All extends Actor {
	
	public static void main(String args[]) {
		Play.main(args, new All()); 
	}
	
	Stage stage;

	public void act() {
		stage = getStage();
		
		setVisible(false);

		while (true) {
			next(new galloway.sam.TryMe(), 300);
			next(new galloway.mike.TryMe(), 200);
			next(new galloway.alex.TryMe(), 800);
			next(new galloway.alex.TryMeStarter(), 1600);
			next(new galloway.corey.TryMe(), 400);
			next(new galloway.corey.TryMeStarter(), 1600);
		}

	}

	public void waitForAll(int n) {
		tracer.printMsg(this, "> waitForAll");
		sleep(1);
		while (stage.getNumberOfActors() > n) {
			super.sleep(1);
		}
		tracer.printMsg(this, "< waitForAll");
	}

	public void waitFor(Actor a) {
		sleep(1);
		tracer.printMsg(this, "> waitFor " + a);
		while (a.isActing()) {
			super.sleep(5);
		}
		tracer.printMsg(this, "< waitFor " + a);
	}

	public void waitFor(Actor[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null)
				waitFor(a[i]);
		}
	}

	public void next(Actor a, int wait) {
		tracer.printMsg(this, "starting " + a); 
		Actor.getDefault().setTrailWidth(1);
		Actor.getDefault().setStepSize(5);
		Actor.getDefault().setVisible(true);
		Actor.getDefault().jumpTo(stage.getCenter());
		
		if (!stage.getArgs().getBoolean(Arguments.APPLET)) {
			Actor t;

			t = new mcm.theater.actor.ShowShape();
			t.setShape(new TextShape(a.getClass().getName(), stage));
			t.setColor(invert(stage.getColor()));
			t.setHotSpot(Shape.LOWER_RIGHT);
			t.jumpTo(stage.getWidth() - 10, 10);
			t.start(stage);

			t = new mcm.theater.actor.ShowShape();
			t.setShape(new TextShape("www.qsoptsolver.com/mcmTheater", stage));
			t.setColor(invert(stage.getColor()));
			t.setHotSpot(Shape.LOWER_LEFT);
			t.jumpTo(10, 10);
			t.start(stage);
		}
		
		a.jumpTo(stage.getCenter()); 
		a.start(stage); 
		
		sleep(wait); 
		
		killAll(); 
		System.gc();
		sleep(2);
		tracer.printMsg(stage, "NEXT\n\n");
	}
	
	public void killAll() {
		tracer.printMsg(this, "> killAll");
		while (stage.getNumberOfActors() > 1) {
			Actor as[] = stage.getActors();
			for (int i = 0; i < as.length && as[i] != null; i++) {
				if (as[i] != this) {
					as[i].terminate();
				}
			}
			super.sleep(1);
		}
		stage.clear();
		tracer.printMsg(this, "< killAll");
	}

	private Color invert(Color c) {
		return new Color((255 - c.getRed()) / 2, 
				          (255 - c.getGreen()) / 2, 
				          (255 - c.getBlue()) / 2);
	}
}