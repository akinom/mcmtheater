/** 
 * A moving Ocean collage with 
 *     clouds moving in the sky 
 *     waves waving at the bottom 
 *     boat crossing the ocean waves 
 */
package collage.ocean;

import java.awt.Color;

import mcm.graphics.ImageShape;
import mcm.graphics.Shape;
import mcm.theater.*;

// Referenced classes of package mcm.lessons.collage:
//            WaveActor, MoveAcrossActor

public class BoatFinal extends Actor {
	public static void main(String argv[]) {
    	Play.main(argv, new BoatFinal()); 
    }
    
	
    int wait = 100;

	Color skyColor = new Color(0, 0, 125);

	String boat = "collage/res/ocean/boat.png";

	String wave = "collage/res/ocean/wave.png";

	String cloudBig = "collage/res/ocean/cloud90.png";

	String cloudSmall = "collage/res/ocean/cloud60.png";
   
	public void act() {
		Stage stage = getStage();
		stage.setMode(Stage.LEAVE);
		stage.setColor(skyColor);
		
		startClouds();
		startWaves();	
		
		// make and start the boat
		Shape boatShape = new ImageShape(boat, Shape.LOWER_RIGHT, getStage());		
		Actor b; 
		b = new Across(); 
		initActor(b, boatShape, 0, 60); 
		b.start(stage, 10);
	}
	
	private void startClouds() { 
		Across  a; 
		Shape bigShape = new ImageShape(cloudBig,  Shape.UPPER_RIGHT, getStage());
		Shape smallShape = new ImageShape(cloudSmall, Shape.UPPER_RIGHT, getStage());

		double cloudY = getStage().getHeight() - 15;
		a = new Across(); 
		initActor(a, bigShape, 50, cloudY - 20);
		a.start(getStage()); 
		
		a = new Across(); 
		initActor(a, smallShape,120, cloudY);
		a.start(getStage()); 
		
		a = new Across(); 
		initActor(a, bigShape,  250, cloudY - 50);
		a.start(getStage()); 
	}
	
	private void startWaves() {
		Stage stage = getStage();
		ImageShape waveShape = new ImageShape(wave, Shape.UPPER_CENTER, getStage());
		if (waveShape.getWidth() < stage.getWidth() + 40) {
			waveShape.setWidth(stage.getWidth() + 40); 
		}
	
		Wave wave; 
		double ctrx = stage.getWidth() / 2;
		wave = new Wave(); 
		initActor(wave, waveShape, ctrx, 83); 
		wave.start(stage, 28); 
	
		wave = new Wave();
		initActor(wave, waveShape, ctrx, 72);
		wave.start(stage, 21);

		wave = new Wave();
		initActor(wave, waveShape, ctrx, 60);
		wave.setDirection(-15);
		wave.start(stage, 14);

		wave = new Wave();
		initActor(wave, waveShape, ctrx, 41);
		wave.start(stage, 7);

		wave = new Wave();
		initActor(wave, waveShape, ctrx, 23);
		wave.setDirection(25);
		wave.start(stage, 0);
	}

	private void initActor(Actor a, Shape shape, double x, double y) 
	{
		a.setShape(shape);
		a.setTrailVisible(false);
		a.setStepSize(3.0);
		a.jumpTo(x, y);
	}
}