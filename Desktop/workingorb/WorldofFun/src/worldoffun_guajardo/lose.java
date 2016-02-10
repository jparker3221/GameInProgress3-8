package worldoffun_guajardo;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
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
        startimage = new Image("res/LossScreen.png");
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

    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_1:
                WorldofFunLvl1.player.health = 100000;
                WorldofFunLvl1.player.speed = .4f;
                WorldofFunLvl1.counter = 0;
                WorldofFunLvl1.player.x = 96f;
                WorldofFunLvl1.player.y = 228f;
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
