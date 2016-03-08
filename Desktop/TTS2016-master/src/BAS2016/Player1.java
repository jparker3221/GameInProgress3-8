package BAS2016;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
public class Player1 {
    public float x = 64f;
    public float y = 64f;
    public int health = 100000;
    public float speed = .4f;
    public int counter = 0;
    float hitboxX = x + 8f;
    float hitboxY = y + 8f;
    private int startX, startY, width = 30, height = 42;
    public Shape rect = new Rectangle(getplayershitboxX(),
            getplayershitboxY(), width, height);
    public float pdelta;
    public Animation playeranime, sprite, up, down, left, right, wait;
    SpriteSheet runningSS;
    public Player1() throws SlickException {
        this.runningSS = new SpriteSheet("res/BratSpriteSheet.png", 64, 64, 0);
up = new Animation();
        up.setAutoUpdate(true);
        up.addFrame(runningSS.getSprite(0, 8), 110);
        up.addFrame(runningSS.getSprite(1, 8), 110);
        up.addFrame(runningSS.getSprite(2, 8), 110);
        up.addFrame(runningSS.getSprite(3, 8), 110);
        up.addFrame(runningSS.getSprite(4, 8), 110);
        up.addFrame(runningSS.getSprite(5, 8), 110);
        up.addFrame(runningSS.getSprite(6, 8), 110);
        up.addFrame(runningSS.getSprite(7, 8), 110);
        up.addFrame(runningSS.getSprite(8, 8), 110);
        down = new Animation();
        down.setAutoUpdate(false);
        down.addFrame(runningSS.getSprite(0, 10), 110);
        down.addFrame(runningSS.getSprite(1, 10), 110);
        down.addFrame(runningSS.getSprite(2, 10), 110);
        down.addFrame(runningSS.getSprite(3, 10), 110);
        down.addFrame(runningSS.getSprite(4, 10), 110);
        down.addFrame(runningSS.getSprite(5, 10), 110);
        down.addFrame(runningSS.getSprite(6, 10), 110);
        down.addFrame(runningSS.getSprite(7, 10), 110);
        down.addFrame(runningSS.getSprite(8, 10), 110);
        left = new Animation();
        left.setAutoUpdate(false);
        left.addFrame(runningSS.getSprite(0, 9), 110);
        left.addFrame(runningSS.getSprite(1, 9), 110);
        left.addFrame(runningSS.getSprite(2, 9), 110);
        left.addFrame(runningSS.getSprite(3, 9), 110);
        left.addFrame(runningSS.getSprite(4, 9), 110);
        left.addFrame(runningSS.getSprite(5, 9), 110);
        left.addFrame(runningSS.getSprite(6, 9), 110);
        left.addFrame(runningSS.getSprite(7, 9), 110);
        left.addFrame(runningSS.getSprite(8, 9), 110);
        right = new Animation();
        right.setAutoUpdate(false);
        right.addFrame(runningSS.getSprite(0, 11), 110);
        right.addFrame(runningSS.getSprite(1, 11), 110);
        right.addFrame(runningSS.getSprite(2, 11), 110);
        right.addFrame(runningSS.getSprite(3, 11), 110);
        right.addFrame(runningSS.getSprite(4, 11), 110);
        right.addFrame(runningSS.getSprite(5, 11), 110);
        right.addFrame(runningSS.getSprite(6, 11), 110);
        right.addFrame(runningSS.getSprite(7, 11), 110);
        right.addFrame(runningSS.getSprite(8, 11), 110);
        wait = new Animation();
        wait.setAutoUpdate(true);
        wait.addFrame(runningSS.getSprite(0, 14), 733);
        wait.addFrame(runningSS.getSprite(1, 14), 733);
        wait.addFrame(runningSS.getSprite(2, 14), 733);
        wait.addFrame(runningSS.getSprite(3, 14), 733);
        sprite = wait;
    }
    public void setpdelta(float somenum) {
        pdelta = somenum;
    }
    public float getpdelta() {
        return pdelta;
    }
    public float getplayersX() {
        return this.x;
    }
    public float getplayersY() {
        return this.y;
    }
    public float getplayershitboxX() {
        return x + 18f;
    }
    public float getplayershitboxY() {
        return y + 18f;
    }
    public void setplayershitboxX() {
        hitboxX = getplayershitboxX();
    }
    public void setplayershitboxY() {
        hitboxY = getplayershitboxY();
    }
}
