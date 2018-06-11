package iterator;

import java.util.List;

/**
 * Created by Edge on 2016/4/17.
 */
public class ThingList extends AbstractThingList{

    public ThingList(List products) {
        super(products);
    }

    //实现创建迭代器对象的具体工厂方法
    public AbstractIterator createIterator() {
        return new ThingIterator(this);
    }
}
