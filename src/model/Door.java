package model;

public class Door {
    int x;
    int y;
    Room room = new Room();

    public void getPosition(int x, int y){
        x = this.x;
        y = this.y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public Room getRoom(){
        return room;
    }
}
