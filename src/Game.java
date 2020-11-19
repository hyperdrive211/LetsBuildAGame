import java.awt.*;
import java.awt.image.BufferStrategy;


/**
 * Created By Jonathon on 19/11/2020
 * Update Comments About Program Here
 **/
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;
    private Thread thread;
    private boolean running = false;
    Handler handler;

   public Game(){
        new Window(WIDTH, HEIGHT, "Let's Build a game", this);
        handler = new Handler();
        handler.addObject(new Player(100, 100, ID.Player));
        handler.addObject(new Player(200, 200, ID.Player));
    }

    public synchronized void start(){
       thread = new Thread(this);
       thread.start();
       running =true;
    }

    public synchronized void stop(){
       try{
           thread.join();
           running = false;
       }catch(Exception e){
           e.printStackTrace();;
       }
    }

    public void run(){
       long lastTime = System.nanoTime();
       double amountTicks = 60.0;
       double ns = 1000000000 / amountTicks;
       double delta = 0;
       long timer = System.currentTimeMillis();
       int frames = 0;
       while(running){
           long now = System.nanoTime();
           delta += (now - lastTime) / ns;
           lastTime = now;
           while(delta >= 1){
               tick();
               delta--;
           }
           if(running)
               render();
               frames++;
           if(System.currentTimeMillis() - timer > 1000){
               timer += 1000;
               System.out.println("FPS: " + frames);
               frames = 0;
           }
       }
       stop();
    }

    private void tick(){
       handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH, HEIGHT);

        handler.render(g);
        g.dispose();
        bs.show();
    }
    public static void main(String [] args){
      new Game();
    }
}
