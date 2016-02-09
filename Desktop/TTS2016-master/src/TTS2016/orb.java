package TTS2016;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class orb {
   private int locationX;
   private int locationY;
   private int size;
   private boolean isVisible;
   Image orbpic;
   Shape hitbox;
   private int x, y;
   
   
   public orb(int x, int y) throws SlickException{
       this.isVisible= false;
       this.locationX = x;
       this.locationY = y;
       this.orbpic = new Image ("res/car.png");
       this.hitbox = new Rectangle (x,y,32,32);
    } 

   
   public void setX(int a){
       this.x = a;
       
   }
   
   public void setY(int a){
       this.x = a;
       
   }
    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Image getOrbpic() {
        return orbpic;
    }

    public void setOrbpic(Image orbpic) {
        this.orbpic = orbpic;
    }

    public Shape getHitbox() {
        return hitbox;
    }

    public void setHitbox(Shape hitbox) {
        this.hitbox = hitbox;
    }
    
    public void setlocation(int a, int b){
     //   this.setLocationX((int)Player.x+16);
       // this.setLocationY((int)Player.y-16);
    }

    
/**
 * getters and setters are a common concept in java
 * a design guideline in java and oop in general
 * is to encapsulate/isolate values as much as possible
 * Getters- are methods used to query the value of instance vars
 * this.getlocationX();
 * Settters- are methods used to set the value of instance vars
 * orb1.setlocationX(playerX, playerY);
**/
   
   
}

