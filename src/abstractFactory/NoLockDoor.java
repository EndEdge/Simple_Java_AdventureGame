package abstractFactory;

import model.Door;
import model.Room;

class NoLockDoor implements Fdoor{
    Door door = new Door();

    public void setPosition(int x, int y){
        door.setPosition(x, y);
    }

    public void getPosition(int x, int y){
        door.getPosition(x,y);
    }

    public void setKey(int key){};

    public boolean checkkey(int key){
        return true;
    }

    public void setRoom(Room room){
        door.setRoom(room);
    }

    public Room getroom(){
        return door.getRoom();
    }

}
