import java.awt.*;
import java.util.LinkedList;

/**
 * Created By Jonathon on 19/11/2020
 * Update Comments About Program Here
 **/
public class Handler {
    LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void tick(){
        for (int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.tick();
        }

    }

    public void render(Graphics g){
       for(int i = 0; i < objects.size(); i++){
           GameObject tempObject = objects.get(i);
           tempObject.render(g);
       }
    }

    public void addObject(GameObject object){
        this.objects.add(object);
    }

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
}
