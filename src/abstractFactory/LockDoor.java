package abstractFactory;

import model.DoorWithLock;
import model.Room;

class LockDoor implements Fdoor{

    DoorWithLock door = new DoorWithLock();

    public void setPosition(int x, int y){
        door.setPosition(x, y);
    }

    public void getPosition(int x, int y){
        door.getPosition(x, y);
    }

    public void setKey(int key){
        door.setKey(key);
    }

    public boolean checkkey(int key){
        return door.checkkey(key);
    }

    public void setRoom(Room room){
        door.setRoom(room);
    }

    public Room getroom(){
        return door.getRoom();
    }
}
