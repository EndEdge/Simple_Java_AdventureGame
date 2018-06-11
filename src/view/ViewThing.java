package view;

import iterator.AbstractIterator;
import iterator.AbstractThingList;
import iterator.ThingList;
import model.Thing;
import observer.ThingObserver;

import java.awt.*;

/**
 * Created by Edge on 2016/4/22.
 */
public class ViewThing implements ThingObserver{
    ThingModel things;
    Thing thing;
    AbstractThingList list;
    AbstractIterator iterator;

    public ViewThing(ThingModel things){
        try {
            this.things = things;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        list = new ThingList(things.things);
        iterator = list.createIterator();
        while(!iterator.isLast()){
            thing = (Thing) iterator.getNextItem();
            g.drawImage(thing.getImage().getImage(), thing.getY()*50, thing.getX()*50, null);
            iterator.next();
        }
    }

    public void dataUpdate(ThingModel model)
    {
        /**@todo: Implement this observer.Observer method*/
        this.things = model;

    }
}
