package BAS2016;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
public class lose extends BasicGameState {
    private StateBasedGame game;
    public Image startimage;
     public lose(int xSize, int ySize) {
    }
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
    	startimage = new Image("res/Game_Lose_Art.jpg");
        this.game = game;
    }
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
    	startimage.draw();
        g.setColor(Color.white);
        g.drawString("press 1 to try again", 400, 320);
    }
   public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {
    }
    public int getID() {
        return 2;
    }
    @Override
    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_1:
             //   Player.health  = 100000;
              //  Player.speed = .4f;
                BAS2016.counter = 0;
             //   Player.x = 2525f;
             //   Player.y = 1200f;
                BAS2016.candy1.isvisible = true;
                BAS2016.candy2.isvisible = true;
                BAS2016.soda1.isvisible = true;
                BAS2016.soda2.isvisible = true;
                BAS2016.destroyable1a.isvisible = true;
                BAS2016.destroyable1b.isvisible = true;
                BAS2016.destroyable1c.isvisible = true;
                BAS2016.destroyable1d.isvisible = true;
                BAS2016.destroyable1e.isvisible = true;
                BAS2016.destroyable2a.isvisible = true;
                BAS2016.destroyable2b.isvisible = true;
                BAS2016.destroyable2c.isvisible = true;
                BAS2016.destroyable2d.isvisible = true;
                BAS2016.destroyable2e.isvisible = true;
                //redo potions and reset cordinates of player
                game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
                break;
            case Input.KEY_2:
                break;
            case Input.KEY_3:
                break;
            default:
                break;
        }
    }
}