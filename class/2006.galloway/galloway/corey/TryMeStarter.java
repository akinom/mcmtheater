package galloway.corey;

import mcm.theater.*; 
import mcm.theater.actor.*;
import mcm.utils.*;
import mcm.graphics.*;
import java.awt.Color;  

public class TryMeStarter extends DrJava {
  
  public void act() {  
    for (int i = 0; i < 8; i++) {
      TryMe tm;        
      tm = new TryMe(); 
      tm.start(getStage());
    }  
    while (true) {
      sleep(1500);
      getStage().clear();
    }  
  }
}

