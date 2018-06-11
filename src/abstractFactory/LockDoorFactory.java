package abstractFactory;

public class LockDoorFactory implements DoorFactory{
    public Fdoor createdoor(){
        return new LockDoor();
    }
}