package view;

import model.Thing;
import observer.ThingObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by Edge on 2016/4/17.
 */
public class ThingModel{
    /*public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
    //ImageIcon ticon = new ImageIcon("000空白.png");
    List things = new ArrayList();
    List observer = new ArrayList();
    Thing thing;

    public ThingModel() {    super();}

    public ThingModel(Thing[] data)
    {
        for ( int i = 0; i< data.length; i++ )
        {
            join(data[i]);
        }
    }

    public void setThing(Thing thing){
        this.thing = thing;
    }

    public void join(Thing thing){
        things.add(thing);
    }

    public void quit(Thing thing){
        things.remove(thing);
    }

    public Thing getData(int idx)
    {
        return (Thing)(things.get(idx));
    }

    public int size()
    {
        return things.size();
    }

    public void registerObserver(ThingObserver o)
    {
        observer.add(o);
    }

    /*void check(){
        if(thing.getplayer(thing.getX(),thing.getY()))
            thing.setImg(ticon);
    }*/

    public void changeModel(ThingModel model)
    {
        things.clear();
        for (int i=0; i<model.size(); i++ )
        {
            this.join(model.getData(i));
        }
        dataUpdate();
    }

    private void dataUpdate()
    {
        for (Iterator i = observer.iterator(); i.hasNext(); )
        {
            ThingObserver o = (ThingObserver)(i.next());
            o.dataUpdate(this);
        }
    }
}
