package galloway.alex;

import mcm.theater.*; 
import mcm.theater.actor.*;
import mcm.utils.*;
import mcm.graphics.*;
import java.awt.Color;  

// see TryMeStart.hist in mcmUser/drJava
// it contains the commands to start a TryMe actor from DrJava's interactions pane 
public class TryMe extends DrJava {
  public void act() {
    while (true) {
      doLooped();
    }
  }
  
  public void doLooped() {
    setTrailWidth(4);
    jumpTo(Dice.throwPoint(getStage()));
    for (int i = 0; i < 9; i++) { 
      doPattern();
      left(90);
    }
  }
  public void doPattern() {
    Actor a = this; 
    a.move(20);
    a.left(90);
    a.move(20);
    a.left(90);
    a.move(20);
    a.left(90);
    a.move(20);
    a.left(135);
    a.move(28.284271247461900976033774484194);
  }
  public void dooldPattern() {
    Actor a = this; 
    a.move(50);
    a.left(45);
    a.left(45);
    a.move(50);
    a.left(90);
    a.move(50);
    a.left(90);
    a.move(50);
    a.left(135);
    a.move(50);
    a.move(10);
    a.move(10);
    a.left(135);
    a.move(50);
    a.left(135);
    a.move(70);
    a.left(135);
    a.move(50);
    a.left(135);
    a.move(40);
    a.move(30);
    a.right(135);
    a.move(25);
    a.right(90);
    a.move(50);
    a.right(90);
    a.move(25);
    a.right(90);
    a.move(25);
    a.right(90);
    a.move(50);
    a.right(180);
    a.move(50);  
  }
}
