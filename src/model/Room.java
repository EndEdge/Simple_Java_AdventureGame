package model;

import java.util.ArrayList;
import java.util.List;

public class Room extends MapSite {

    List things = new ArrayList();
    List openDoor = new ArrayList();
    List lockDoor = new ArrayList();
    String name = new String();
    int id;

    public void setThings(List things){
        this.things = things;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setOpenDoor(List openDoor){
        this.openDoor = openDoor;
    }

    public void setLockDoor(List lockDoor){
        this.lockDoor = lockDoor;
    }


}
