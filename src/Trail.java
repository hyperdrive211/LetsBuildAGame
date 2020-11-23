import java.awt.*;

/**
 * Created By Jonathon on 21/11/2020
 * Update Comments About Program Here
 **/
public class Trail extends GameObject {

    private float alpha = 1;
    private Handler handler;
    private Color color;

    private int width;
    private int height;
    private float life;
    public Trail(int x, int y, ID id, int width, int height, float life,  Color color,  Handler handler) {
        super(x, y, id);
        this.width = width;
        this.height= height;
        this.color = color;
        this.life = life;
        this.handler = handler;
    }

    @Override
    public void tick() {
      if(alpha > life){
          alpha -= life - 0.001f;
      } else{
          handler.removeObject(this);
      }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect(x,y,width,height);
        g2d.setComposite(makeTransparent(1));

    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
