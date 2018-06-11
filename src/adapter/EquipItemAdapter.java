package adapter;

import decorator.EquipItem;

/**
 * Created by Edge on 2016/4/18.
 */
public class EquipItemAdapter implements ThingInterface{

    EquipItem item;

    public EquipItemAdapter(EquipItem item){
        this.item = item;
    }

    public void setposition(int x, int y) {
        item.setsite(x, y);
    }

}
