package MissileSpaceShip;

//In the next example we add another sprite type to our example-a missile//
//The missiles are launched with the space key//
//The Sprite class shares common code from the Missiile and SpaceShip classes//
import java.awt.Image;
import javax.swing.ImageIcon;

public class Sprite {
  
  protected int x;
  protected int y;
  protected int width;
  protected int height;
  protected boolean visible;
  protected Image image;
  
  public Sprite(int x, int y) {
    
    this.x = x;
    this.y = y;
    visible = true;
  }
  
  //The constructor initiates the x and y coordinates and the visible variable//
  //This is similar to the previous Sprite class I have created//
  
  protected void loadImage(String imageName) {
    
    ImageIcon ii = new ImageIcon (imageName);
    image = ii.getImage();
    
  }
  
  protected void getImageDimensions() {
    
    width = image.getWidth(null);
    height = image.getHeight(null);
  }
  
  public Image getImage() {
    return image;
  }
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
  public boolean isVisible() {
    return visible;
  }
  
  public void setVisible(Boolean visible)
    this.visible = visible;
  }
}
