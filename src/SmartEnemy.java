/**
 * Created By Jonathon on 25/11/2020
 * Update Comments About Program Here
 **/

import java.awt.*;
/**
 * Created By Jonathon on 21/11/2020
 * Update Comments About Program Here
 **/

public class SmartEnemy extends GameObject {
    private Handler handler;
    private GameObject player;
    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for(int i = 0; i <handler.objects.size(); i++){
             if(handler.objects.get(i).getId() == ID.Player)
                 player = handler.objects.get(i);
        }

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,16,16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        velX = (float)((-1.0/distance) * diffX);
        velY = (float)((-1.0/distance) * diffY);

        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <=0 || x >= Game.WIDTH - 16) velX *= -1;
        handler.addObject(new Trail((int)x,(int)y,ID.Trail, 16, 16, 0.02f,Color.cyan, handler ));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x,(int)y,16,16);
    }
}
