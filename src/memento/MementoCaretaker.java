package memento;

/**
 * Created by Edge on 2016/4/18.
 */
public class MementoCaretaker {
    private PlayerMemento memento;

    public PlayerMemento getMenmento(){
        return memento;
    }

    public void setMemento(PlayerMemento memento){
        this.memento = memento;
    }
}
