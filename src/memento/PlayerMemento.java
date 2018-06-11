package memento;

import data.PlayerData;
import model.Player;

/**
 * Created by Edge on 2016/4/18.
 */
public class PlayerMemento {
    private PlayerData data;
    private int x;
    private int y;

    public PlayerMemento(PlayerData data, int x, int y){
        this.data = data;
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public PlayerData getData(){
        return data;
    }

}
