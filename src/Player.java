import java.awt.*;
import java.util.Random;

/**
 * Created By Jonathon on 19/11/2020
 * Update Comments About Program Here
 **/
public class Player extends GameObject{

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler){
        super(x,y,id);
        this.handler = handler;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,32, 32);
    }

    public void tick(){
         x += velX;
         y += velY;
         x = Game.clamp(x, 0, Game.WIDTH -37);
         y = Game.clamp(y, 0, Game.HEIGHT - 60);

         handler.addObject(new Trail((int)x,(int)y, ID.Trail, 32, 32,0.05f, Color.WHITE, handler));
         collision();
    }

    private void collision(){
        for(int i = 0; i < handler.objects.size(); i ++){
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){ //the temp object is essentially a ref to a basic enemy
                //check for collisions
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.health -= 2;
                }
            }
        }
    }

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.red);
        g2d.draw(getBounds());
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 32, 32);
    }


}
