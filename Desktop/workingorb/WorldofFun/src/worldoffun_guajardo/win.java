/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldoffun_guajardo;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import static worldoffun_guajardo.WorldofFunLvl1.player;
import static worldoffun_guajardo.WorldofFunLvl1.antidote;

public class win extends BasicGameState {

    private StateBasedGame game;

    public win(int xSize, int ySize) {
    }

    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        this.game = game;
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {
        g.setColor(Color.white);
        g.drawString("You found the antidote in time!", 380, 200);
        g.drawString("press 1 to play again", 400, 320);
    }

    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {

    }

    public int getID() {
        return 3;
    }

    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_1:

                player.health = 100000;
                player.speed = .4f;
                WorldofFunLvl1.counter = 0;
                player.x = 96f;
                player.y = 228f;

                // Item.isvisible = true;
                //item1.isvisible = true;
                antidote.isvisible = true;
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
