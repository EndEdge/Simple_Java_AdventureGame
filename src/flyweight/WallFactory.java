package flyweight;

import java.util.Hashtable;

/**
 * Created by Edge on 2016/4/17.
 */
public class WallFactory {
    private static WallFactory instance = new WallFactory();
    private static Hashtable ht;

    private WallFactory(){
        ht = new Hashtable();
        Wall wall100,wall101,wall102;
        wall100 = new Wall100();
        ht.put(0, wall100);
        wall101 = new Wall101();
        ht.put(1, wall101);
        wall102 = new Wall102();
        ht.put(2, wall102);
    }

    public static WallFactory getInstance(){
        return instance;
    }

    public static Wall getWall(int id){
        return (Wall)ht.get(id);
    }
}
