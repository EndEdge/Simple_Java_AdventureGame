package abstractFactory;

public class NoLockDoorFactory implements DoorFactory{
    public Fdoor createdoor(){
        return new NoLockDoor();
    }
}
