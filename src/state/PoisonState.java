package state;

/**
 * Created by Edge on 2016/4/25.
 */
public class PoisonState implements State {

    @Override
    public void set(StateManager stateManager) {
        stateManager.name = "Poison";
        stateManager.data.hp -= 1;
    }

}