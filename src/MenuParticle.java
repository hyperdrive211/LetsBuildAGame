import java.awt.*;
import java.util.Random;

/**
 * Created By Jonathon on 26/11/2020
 * Update Comments About Program Here
 **/
public class MenuParticle extends GameObject {
    private Handler handler;
    Random r  = new Random();

    private Color col;
    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        velY = 2;
        velX = 9;
        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        this.handler = handler;


    }

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,16,16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <=0 || x >= Game.WIDTH - 16) velX *= -1;
        handler.addObject(new Trail((int)x,(int)y,ID.Trail, 16, 16, 0.02f,Color.cyan, handler ));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect((int)x,(int)y,16,16);
    }
}
