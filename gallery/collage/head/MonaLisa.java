/*
 * Created on Sep 30, 2005
 *
 * Two actors carrying Mona Lisa's body and head. 
 * The body is stationary, the head slides back and forth 
 * 
 * @author Monika Mevenkamp
 */
package collage.head;

import mcm.graphics.ImageShape;
import mcm.graphics.Shape;
import mcm.theater.*;
import mcm.theater.actor.*;
import java.awt.Color;

public class MonaLisa extends Actor {

	public void act() {
		// get stage for later reference
		Stage stage = getStage();
		// set stage's background color to a dark brown 
		stage.setColor(new Color(65, 63, 51));
		
		// create body, and head images from files and 
		// set their hot spots to LOWER_CENTER
		ImageShape body = new ImageShape("collage/res/head/bot.gif", getStage());
		ImageShape head = new ImageShape("collage/res/head/top.gif", getStage());
		body.setHotSpot(Shape.LOWER_CENTER);
		head.setHotSpot(Shape.LOWER_CENTER);
			
		// we need to know the combined height of the images 
		double totalHeight = body.getHeight() + head.getHeight();
		// check whether images are too big for stage 
		if (totalHeight > stage.getHeight()) {
			double scale = stage.getHeight() / totalHeight; 
			body.setSize(body.getWidth() * scale, body.getHeight() * scale); 
			head.setSize(head.getWidth() * scale, head.getHeight() * scale); 
			totalHeight = stage.getHeight(); 
		}
		// offset is the offset of the body image from the lower edge of the stage
		double offset = (stage.getHeight() - totalHeight) / 2;
		// ctrx is the x coordinate of the stage's center
		double ctrx = stage.getWidth() / 2; 

		// create actor for body image; 
		// since it stays in place use a predefined ShowShape Actor  
		// position at (ctrx, offset);
		// since the image's hot spot is set to LOWER_CENTER it will be 
		// positioned such that the image's LOWER_CENTER point is displayed 
		// at the actor's position
		Actor a; 
		a = new ShowShape();
		a.setShape(body);
		a.jumpTo(ctrx, offset);
		a.start(stage);

		// create actor for head image 
		// this is the moving head, so use a WiggleSlice Actor 
		// position height of body image pixels higher than the body image 
		a = new BackForth();
		a.setShape(head);
		a.jumpTo(ctrx, offset + body.getHeight());
		a.setTrailVisible(false);
		a.start(stage);
	}
}