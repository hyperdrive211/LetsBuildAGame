import java.awt.*;
import java.util.Random;

/**
 * Created By Jonathon on 19/11/2020
 * Update Comments About Program Here
 **/
public class Player extends GameObject{

    Random r = new Random();

    public Player(int x, int y, ID id){
        super(x,y,id);
        velX = r.nextInt(10) +1;
        velY = r.nextInt(5) +1;

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
