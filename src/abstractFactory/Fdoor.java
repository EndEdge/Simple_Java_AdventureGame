package abstractFactory;

import model.Room;

/**
 * Created by Edge on 2016/4/16.
 */
public interface Fdoor {
    public void setPosition(int x, int y);
    public void getPosition(int x, int y);
    public void setKey(int key);
    public boolean checkkey(int key);
    public void setRoom(Room room);
    public Room getroom();
}
