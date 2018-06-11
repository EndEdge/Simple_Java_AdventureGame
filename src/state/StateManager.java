package state;

import data.PlayerData;

public class StateManager {
    private State state;
    public PlayerData data;
    public String name = new String();

    public void setState(State state){
        this.state = state;
    }

    public void getData(PlayerData data){
        this.data = data;
    }

    public String getName(){
        return name;
    }

    public void getPoison(){
        state = new PoisonState();
        state.set(this);
    }

}
