package MissileSpaceShip;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

//This is the SpaceShip class//

public class SpaceShip extends Sprite [
  
  private int dx;
  private int dy;
  private List<Missile> missiles;
  
  public SpaceShip(int x, int y) {
    super(x, y);
    
    initSpaceShip();
  }
  
  private void initSpaceShip() {
    
    missiles = new ArrayList<>();
    
    loadImage("src/resources/spaceship.png");
    getImageDimensions();
  }
  
  public void move() {
    x += dx;
    y += dy;
  }
  
  public List<Missile> getMissile() {
    return missiles;
  }
  
  //The getMissiles() method returns the list of missiles//
  //It is called from the Board class//
  
  public void keyPressed(KeyEvent e) {
    
    int key = e.getKeyCode();
    
    if (key == KeyEvent.VK_SPACE) {
      fire();
    }
    //If we press the Space key, we fire//
        
    if (key == KeyEvent.VK_LEFT) {
      dx = -1;
    }
    
    if (key == KeyEvent.VK_RIGHT) {
      dx = 1;
    }
    
    if (key == KeyEvent.VK_UP) {
      dy = -1;
    }
    
    if (key == KeyEvent.VK_DOWN) {
      dy = 1;
    }
  }
  
  public void fire() {
    missiles.add(new Missile(x + width, y + height / 2));
  }
  
  //The fire() method creates a new Missile object and adds it to the list of missiles//
  
  public void keyReleased(KeyEvent e) {
    
    int key = e.getKeyCode();
    
    if (key == KeyEvent.VK_LEFT) {
      dx = 0;
    }
    
    if (key == KeyEvent.VK_RIGHT) {
      dx = 0;
    }
    
    if (key == KeyEvent.VK_UP) {
      dy = 0;
    }
    
    if (key == KeyEvent.VK_DOWN) {
      dy = 0;
    }
  }
}  
                                 
