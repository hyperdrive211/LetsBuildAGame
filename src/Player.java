import java.awt.*;

/**
 * Created By Jonathon on 19/11/2020
 * Update Comments About Program Here
 **/
public class Player extends GameObject{
    public Player(int x, int y, ID id){
        super(x,y,id);
    }

    public void tick(){
         x += velX;
         y += velY;
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
}
