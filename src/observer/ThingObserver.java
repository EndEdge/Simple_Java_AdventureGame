package observer;

import view.ThingModel;

/**
 * Created by Edge on 2016/4/18.
 */
public interface ThingObserver {
    public void dataUpdate(ThingModel thingModel);
}
