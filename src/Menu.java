import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created By Jonathon on 26/11/2020
 * Update Comments About Program Here
 **/
public class Menu  extends MouseAdapter {

   private Game game;
   private Handler handler;

    public Menu (Game game,Handler handler){
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e){
        //storing position of where the mouse has been clicked.
      int mx = e.getX();
      int my = e.getY();

      //Play button click
        if(mouseOver(mx, my, 210, 150, 200, 64)){
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player(game.WIDTH/2-32, game.HEIGHT/2-32, ID.Player, handler));
        }

        //Quite Button
        if(mouseOver(mx, my,210, 350, 200, 64)){
            System.exit(1);
        }
    }

    public void mouseReleased(MouseEvent e){

    }
    public void render(Graphics g){
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Menu", 240, 70);
        g.setFont(fnt2);
        g.drawRect(210,150,200,64);
        g.drawString("Play", 270, 190);
        g.drawRect(210,250,200,64);
        g.drawString("Help", 270, 290);
        g.drawRect(210,350,200,64);
        g.drawString("Exit", 270, 390);

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
       if(mx >x && mx < x + width){
              if(my > y && y < y + height){
                  return true;
              }else return false;
       } else return false;
    }

    public void tick(){

    }


}
