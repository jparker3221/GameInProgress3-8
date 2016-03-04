package BAS2016;
import org.newdawn.slick.state.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

public class BAS2016 extends BasicGameState {
    public static Candy candy1, candy2;
    public static Soda soda1, soda2;
    public Player1 player1;
    public Player2 player2;
    public Maid Mary, Esperanza;
    public Butler Thomas, Alfred;
    public static Destroyable1 destroyable1a, destroyable1b, destroyable1c,
            destroyable1d, destroyable1e;
    public static Destroyable2 destroyable2a, destroyable2b, destroyable2c,
            destroyable2d, destroyable2e;
    public static orb magic8ball, orb1;
    public ArrayList<Candy> Candyshop = new ArrayList();
    public ArrayList<Soda> Sodashop = new ArrayList();
    public static ArrayList<Maid> brushes = new ArrayList();
    public static ArrayList<Butler> platters = new ArrayList();
    public ArrayList<Destroyable1> desks = new ArrayList();
    public ArrayList<Destroyable2> tables = new ArrayList();
    private static TiledMap grassMap;
    private static AppGameContainer app;
    private static Camera camera;
    public static int counter = 0;
    private static final int SIZE = 64;
    private static final int SCREEN_WIDTH = 1000;
    private static final int SCREEN_HEIGHT = 750;

    public BAS2016(int xSize, int ySize) {
    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        gc.setTargetFrameRate(60);
        gc.setShowFPS(false);
        grassMap = new TiledMap("res/BattleMap2.tmx");
        camera = new Camera(gc, grassMap);
        
        
        Blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];
        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int tileID = grassMap.getTileId(xAxis, yAxis, 1);
                String value = grassMap.getTileProperty(tileID,
                        "blocked", "false");
                if ("true".equals(value)) {
                    Blocked.blocked[xAxis][yAxis] = true;
                }
            }
        }
        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int tileID = grassMap.getTileId(xAxis, yAxis, 3);
                String value = grassMap.getTileProperty(tileID,
                        "blocked", "false");
                if ("true".equals(value)) {
                    Blocked.blocked[xAxis][yAxis] = true;
                }
            }
        }
        player1 = new Player1();
        candy1 = new Candy(2335, 345);
        candy2 = new Candy(3450, 365);
        Candyshop.add(candy1);
        Candyshop.add(candy2);
        soda1 = new Soda(90, 220);
        soda2 = new Soda(6180, 1065);
        Sodashop.add(soda1);
        Sodashop.add(soda2);
        Mary = new Maid(125, 750);
        Esperanza = new Maid(6200, 825);
        Thomas = new Butler(3350, 600);
        Alfred = new Butler(4350, 710);
        brushes.add(Mary);
        brushes.add(Esperanza);
        platters.add(Thomas);
        platters.add(Alfred);
        destroyable1a = new Destroyable1(2225, 1375);
        destroyable1b = new Destroyable1(1800, 1300);
        destroyable1c = new Destroyable1(5800, 300);
        destroyable1d = new Destroyable1(3750, 375);
        destroyable1e = new Destroyable1(4000, 150);
        desks.add(destroyable1a);
        desks.add(destroyable1b);
        desks.add(destroyable1c);
        desks.add(destroyable1d);
        desks.add(destroyable1e);
        destroyable2a = new Destroyable2(2700, 1825);
        destroyable2b = new Destroyable2(4542, 130);
        destroyable2c = new Destroyable2(5383, 1530);
        destroyable2d = new Destroyable2(2570, 775);
        destroyable2e = new Destroyable2(4050, 385);
        tables.add(destroyable2a);
        tables.add(destroyable2b);
        tables.add(destroyable2c);
        tables.add(destroyable2d);
        tables.add(destroyable2e);
        magic8ball = new orb((int) player1.getplayersX(), (int) player1.getplayersY());
    }
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        camera.centerOn((int) player1.x, (int) player1.y);
        camera.drawMap();
        camera.translateGraphics();
        player1.sprite.draw((int) player1.x, (int) player1.y);
        g.drawString("Health: " + player1.health / 1000, camera.cameraX + 10,
                camera.cameraY + 10);
        g.drawString("speed: " + (int) (player1.speed * 10), camera.cameraX + 10,
                camera.cameraY + 25);
        g.drawString("time passed: " + counter / 1000, camera.cameraX + 600, camera.cameraY);
        for (Candy n : Candyshop) {
            if (n.isvisible) {
                n.currentImage.draw(n.x, n.y);
            }
        }
        for (Soda s : Sodashop) {
            if (s.isvisible) {
                s.currentImage.draw(s.x, s.y);
            }
        }
        for (Maid e : brushes) {
            if (e.isAlive) {
                e.currentanime.draw(e.Bx, e.By);
            }
        }
        for (Butler e : platters) {
            if (e.isAlive) {
                e.currentanime.draw(e.Bx, e.By);
            }
        }
        for (Destroyable1 d1 : desks) {
            if (d1.isvisible) {
                d1.currentImage.draw(d1.x, d1.y);
            }
        }
        for (Destroyable2 d2 : tables) {
            if (d2.isvisible) {
                d2.currentImage.draw(d2.x, d2.y);
            }
        }
        if (magic8ball.isIsVisible()) {
            magic8ball.orbpic.draw(magic8ball.getLocationX(), magic8ball.getLocationY());
        }
    }
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
            if(player1.counter >= 9){
            sbg.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            }
            counter += delta;
            Input input = gc.getInput();
            float fdelta = delta * player1.speed;
            player1.setpdelta(fdelta);
            double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);
            float projectedright = player1.x + fdelta + SIZE;
            boolean cangoright = projectedright < rightlimit;
        
            if (input.isKeyDown(Input.KEY_UP)) {
                player1.sprite = player1.up;
                float fdsc = (float) (fdelta - (SIZE * .15));
                if (!(isBlocked(player1.x, player1.y - fdelta) || isBlocked((float) (player1.x + SIZE + 1.5), player1.y - fdelta))) {
                    player1.sprite.update(delta);
                    player1.y -= fdelta;
                    System.out.println("up!");
                }
            } else if (input.isKeyDown(Input.KEY_DOWN)) {
                player1.sprite = player1.down;
                if (!isBlocked(player1.x, player1.y + SIZE + fdelta)
                        || !isBlocked(player1.x + SIZE - 1, player1.y + SIZE + fdelta)) {
                    player1.sprite.update(delta);
                    player1.y += fdelta;
                }
            } else if (input.isKeyDown(Input.KEY_LEFT)) {
                player1.sprite = player1.left;
                if (!(isBlocked(player1.x - fdelta, player1.y) || isBlocked(player1.x
                        - fdelta, player1.y + SIZE - 1))) {
                    player1.sprite.update(delta);
                    player1.x -= fdelta;
                }
            } else if (input.isKeyDown(Input.KEY_RIGHT)) {
                player1.sprite = player1.right;
                if (cangoright
                        && (!(isBlocked(player1.x + SIZE + fdelta,
                                player1.y) || isBlocked(player1.x + SIZE + fdelta, player1.y
                                + SIZE - 1)))) {
                    player1.sprite.update(delta);
                    player1.x += fdelta;
                }
            }
            else if (input.isKeyDown(Input.KEY_0)) {
                orb1.setX((int) player1.x); 
            orb1.setY((int) player1.y);
            orb1.hitbox.setX((int) orb1.getLocationX());
                orb1.hitbox.setY((int) orb1.getLocationY());
                orb1.setIsVisible(!orb1.isIsVisible());
            }
            if (input.isKeyDown(Input.KEY_W)) {
                player2.sprite = player2.up;
                float fdsc = (float) (fdelta - (SIZE * .15));
                if (!(isBlocked(player2.x, player2.y - fdelta) || isBlocked((float) (player2.x + SIZE + 1.5), player2.y - fdelta))) {
                    player2.sprite.update(delta);
                    player2.y -= fdelta;
                    System.out.println("up!");
                }
            } else if (input.isKeyDown(Input.KEY_S)) {
                player2.sprite = player2.down;
                if (!isBlocked(player2.x, player2.y + SIZE + fdelta)
                        || !isBlocked(player2.x + SIZE - 1, player2.y + SIZE + fdelta)) {
                    player2.sprite.update(delta);
                    player2.y += fdelta;
                }
            } else if (input.isKeyDown(Input.KEY_A)) {
                player2.sprite = player2.left;
                if (!(isBlocked(player2.x - fdelta, player2.y) || isBlocked(player2.x
                        - fdelta, player2.y + SIZE - 1))) {
                    player2.sprite.update(delta);
                    player2.x -= fdelta;
                }
            } else if (input.isKeyDown(Input.KEY_D)) {
                player2.sprite = player2.right;
                if (cangoright
                        && (!(isBlocked(player2.x + SIZE + fdelta,
                                player2.y) || isBlocked(player2.x + SIZE + fdelta, player2.y
                                + SIZE - 1)))) {
                    player2.sprite.update(delta);
                    player2.x += fdelta;
                }
            }else if (input.isKeyDown(Input.KEY_Z)) {
                orb1.setX((int) player2.x); 
            orb1.setY((int) player2.y);
            orb1.hitbox.setX((int) orb1.getLocationX());
                orb1.hitbox.setY((int) orb1.getLocationY());
                orb1.setIsVisible(!orb1.isIsVisible());
            }
            player1.rect.setLocation(player1.getplayershitboxX(),
                    player1.getplayershitboxY());
            for (Candy n : Candyshop) {
                if (player1.rect.intersects(n.hitbox)) {
                    if (n.isvisible) {
                        player1.health += 100000;
                        n.isvisible = false;
                    }
                }
            }
            for (Maid m : brushes) {
                if (Math.abs(player1.x - m.Bx) < 576) {
                    m.move();
                }
            }
            for (Maid e : brushes) {
                if (player1.rect.intersects(e.rect)) {
                    {
                        player1.health -= 150;
                    }
                }
            }
            for (Butler b : platters) {
                if (Math.abs(player1.x - b.Bx) < 512) {
                    b.move();
                }
            }
            for (Butler e : platters) {
                if (player1.rect.intersects(e.rect)) {
                    //System.out.println("yay");
                    {
                        player1.speed -= .005f;
                    }
                }
                if (Butler.rect.intersects(e.rect)) {
                }
            }
            for (Soda s : Sodashop) {
                if (player1.rect.intersects(s.hitbox)) {
                    //System.out.println("yay");
                    if (s.isvisible) {
                        player1.speed += .3f;
                        s.isvisible = false;
                    }
                }
            }
            for (Destroyable1 d : desks) {
                if (player1.rect.intersects(d.hitbox)) {
                    //System.out.println("yay");
                    if (d.isvisible) {
                        player1.counter += 1;
                        d.isvisible = false;
                    }
                }
            }
            for (Destroyable2 d : tables) {
                if (player1.rect.intersects(d.hitbox)) {
                    //System.out.println("yay");
                    if (d.isvisible) {
                        player1.counter += 1;
                        d.isvisible = false;
                    }
               }
            }
            player1.health -= counter / 1000;
            if (player1.health <= 0 || player1.speed <= 0f) {
                sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            }
            
            player2.rect.setLocation(player2.getplayershitboxX(),
                    player2.getplayershitboxY());
            for (Candy n : Candyshop) {
                if (player2.rect.intersects(n.hitbox)) {
                    if (n.isvisible) {
                        player2.health += 100000;
                        n.isvisible = false;
                    }
                }
            }
            for (Maid m : brushes) {
                if (Math.abs(player2.x - m.Bx) < 576) {
                    m.move();
                }
            }
            for (Maid e : brushes) {
                if (player2.rect.intersects(e.rect)) {
                    {
                        player2.health -= 150;
                    }
                }
            }
            for (Butler b : platters) {
                if (Math.abs(player2.x - b.Bx) < 512) {
                    b.move();
                }
            }
            for (Butler e : platters) {
                if (player2.rect.intersects(e.rect)) {
                    //System.out.println("yay");
                    {
                        player2.speed -= .005f;
                    }
                }
                if (Butler.rect.intersects(e.rect)) {
                }
            }
            for (Soda s : Sodashop) {
                if (player2.rect.intersects(s.hitbox)) {
                    //System.out.println("yay");
                    if (s.isvisible) {
                        player2.speed += .3f;
                        s.isvisible = false;
                    }
                }
            }
            for (Destroyable1 d : desks) {
                if (player2.rect.intersects(d.hitbox)) {
                    //System.out.println("yay");
                    if (d.isvisible) {
                        player2.counter += 1;
                        d.isvisible = false;
                    }
                }
            }
            for (Destroyable2 d : tables) {
                if (player1.rect.intersects(d.hitbox)) {
                    //System.out.println("yay");
                    if (d.isvisible) {
                        player1.counter += 1;
                        d.isvisible = false;
                    }
               }
            }
            player1.health -= counter / 1000;
            if (player1.health <= 0 || player1.speed <= 0f) {
                sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
            }
//            if (orb1.hitbox.intersects(Butler.rect)) {
  //              Butler.isVisible = false;
    //        }
//            if (orb1.hitbox.intersects(Butler.rect)) {
  //              Butler.isVisible = false;
    //        }
        }
    
    public int getID() {
        return 1;
    }
    private boolean isBlocked(float tx, float ty) {
        int xBlock = (int) tx / SIZE;
        int yBlock = (int) ty / SIZE;
        return Blocked.blocked[xBlock][yBlock];
    }
    public static void moveEnemies() throws SlickException {
        for (Maid m : brushes) {
            m.move();
        }
        for (Butler b : platters) {
            b.move();
        }
    }
}