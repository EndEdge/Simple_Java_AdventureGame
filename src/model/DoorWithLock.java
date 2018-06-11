package model;

public class DoorWithLock extends Door {
    int key;

    public void setKey(int key){
        this.key = key;
    }

    public boolean checkkey(int key){
        if(key == this.key){
            return true;
        }
        return false;
    }
}
