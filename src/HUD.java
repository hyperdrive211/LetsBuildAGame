import java.awt.*;

/**
 * Created By Jonathon on 21/11/2020
 * Update Comments About Program Here
 **/
public class HUD  {

    public static int health = 100;
    private int greenValue = 255;

    private int score= 0;
    private int level = 1;

    public void tick(){
        health = Game.clamp(health, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);
        greenValue = health * 2;
        score++;

    }

    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15,15, 200, 32);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15,15, health *2 , 32);
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);

        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 10, 80);
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return level;
    }
}
