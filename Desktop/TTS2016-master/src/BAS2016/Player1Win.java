/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAS2016;


import org.newdawn.slick.Color;


import org.newdawn.slick.Game;


import org.newdawn.slick.GameContainer;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


import org.newdawn.slick.Input;
import org.newdawn.slick.Music;


import org.newdawn.slick.SlickException;


import org.newdawn.slick.state.BasicGameState;


import org.newdawn.slick.state.StateBasedGame;


import org.newdawn.slick.state.transition.FadeInTransition;


import org.newdawn.slick.state.transition.FadeOutTransition;



public class Player1Win extends BasicGameState {
    private StateBasedGame game;
    static Music win;
    public Image startimage;
     public Player1Win(int xSize, int ySize) {
    }
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {
        
        win=new Music("res/WinMusic.ogg");
    	startimage = new Image("res/Game_Open_Art.jpg");
        this.game = game;
        //win.loop();
        this.game = game;

// TODO AutoÃ¢â‚¬Âgenerated method stub

    }



   


    public void render(GameContainer container, StateBasedGame game, Graphics g)


            throws SlickException {


// TODO AutoÃ¢â‚¬Âgenerated method stub


        g.setColor(Color.white);


        g.drawString("You got your toys!!", 380, 200);
        g.drawString("press 1 to play again", 400, 320);


       


    }



    


    public void update(GameContainer container, StateBasedGame game, int delta)


            throws SlickException {


// TODO AutoÃ¢â‚¬Âgenerated method stub


    }



  


    public int getID() {


// TODO AutoÃ¢â‚¬Âgenerated method stub


        return 3;


    }



    @Override


    public void keyReleased(int key, char c) {


        switch (key) {


            case Input.KEY_1:

              //  Player.health  = 100000;
           //     Player.speed = .4f;
                BAS2016.counter = 0;
            //    Player.x = 2525f;
          //      Player.y = 1200f;
           //     Player.counter = 0;
                
                
                //item.isvisible = true;
                //item1.isvisible = true;
               
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
                
                game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));


                break;


            case Input.KEY_2:


// TODO: Implement later


                break;


            case Input.KEY_3:


// TODO: Implement later


                break;


            default:


                break;


        }


    }


}
