package iterator;

import model.Thing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edge on 2016/4/17.
 */
public abstract class AbstractThingList {

    protected List objects = new ArrayList();

    public AbstractThingList(List objects) {
        this.objects = objects;
    }

    public void addObject(Object obj) {
        this.objects.add(obj);
    }

    public void removeObject(Object obj) {
        this.objects.remove(obj);
    }

    public List getObjects() {
        return this.objects;
    }

    //声明创建迭代器对象的抽象工厂方法
    public abstract AbstractIterator createIterator();

}
