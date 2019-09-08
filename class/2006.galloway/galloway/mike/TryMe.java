package galloway.mike;

import mcm.theater.*; 
import mcm.theater.actor.*;
import mcm.utils.*;
import mcm.graphics.*;
import java.awt.Color;  

// see TryMeStart.hist in mcmUser/drJava
// it contains the commands to start a TryMe actor from DrJava's interactions pane 
public class TryMe extends DrJava {
  
	public void act() {
		doPattern();
	}
	
  public void doPattern() {
    Actor a = this; 
    a.move(50);
    
    a.right(90);
    
    a.move(100);
    
    a.right(90);
    
    a.move(100);
    
    a.right(90);
    
    a.move(100);
    
    a.right(90);
    
    a.move(50);
    
    a.left(45);
    
    a.move(50);
    
    a.left(40);
    
    a.move(20);
    
    a.left(50);
    
    a.right(40);
    
    a.move(20);
    
    a.left(40);
    
    a.move(50);
    
    a.left(45);
    
    a.left(45);
    
    a.move(50);
    
    a.left(40);
    
    a.move(20);
    
    a.left(10);
    
    a.move(20);
    
    a.left(40);
    
    a.move(50);
    
  }
}