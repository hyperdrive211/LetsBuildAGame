import java.util.Random;

/**
 * Created By Jonathon on 23/11/2020
 * Update Comments About Program Here
 **/
public class Spawn {

    private Handler handler;
    private HUD hud;

    private Random r = new Random();
    private int scoreKeep;

    public Spawn(Handler handler, HUD hud){
      this.handler = handler;
      this.hud = hud;
    }

    public void tick(){
       scoreKeep++;
       if(scoreKeep >= 300){
           scoreKeep = 0;
           hud.setLevel(hud.getLevel() + 1);

           for(int i = 0; i < hud.getLevel(); i ++){
               handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
           }
       }
}
    }
