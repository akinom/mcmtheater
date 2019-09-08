package galloway.corey;

import mcm.theater.*; 
import mcm.theater.actor.*;
import mcm.utils.*;
import mcm.graphics.*;
import java.awt.Color;  

// see TryMeStart.hist in mcmUser/drJava
// it contains the commands to start a TryMe actor from DrJava's interactions pane 
public class TryMe extends DrJava {
  
  public void act() {
  TryMe a =this;
   while (true) {
      a.doPattern();
      a.jumpTo(Dice.throwPoint(getStage()));
      a.setColor(Dice.throwColor());
      a.setTrailColor(Dice.throwColor());    }
  }
  
  public void doPattern() {
    Actor a = this; 
    for (int i =0;i<8;i++){
      a.move(50);     
      a.right(45);
    }   
  }
  
  public void upoct() {
    Actor a = this; 
    a.left(90);
    a.move(50);
    a.left(45);
    a.move(50);
    a.right(45);
    a.move(50);
    a.right(45);
    a.move(50);
    a.right(45);
  }
}

