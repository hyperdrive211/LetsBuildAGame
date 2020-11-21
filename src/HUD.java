import java.awt.*;

/**
 * Created By Jonathon on 21/11/2020
 * Update Comments About Program Here
 **/
public class HUD  {

    public static int HEALTH = 100;

    public void tick(){

    }

    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15,15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15,15, HEALTH *2 , 32);
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);
    }
}
