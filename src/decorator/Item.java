package decorator;

import data.ItemData;

/**
 * Created by Edge on 2016/4/18.
 */
public abstract class Item {
    ItemData item;

    public abstract String getname();

    public abstract int getid();

    public abstract int getweight();

    public abstract String gettype();

}
