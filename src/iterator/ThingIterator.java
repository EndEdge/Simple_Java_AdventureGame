package iterator;

import model.Thing;

import java.util.List;

/**
 * Created by Edge on 2016/4/17.
 */
class ThingIterator implements AbstractIterator{

    private ThingList productList;
    private List products;
    private int cursor1; //定义游标，用于记录正向遍历的位置
    private int cursor2; //定义游标，用于记录逆向遍历的位置

    public ThingIterator(ThingList list) {
        this.productList = list;
        this.products = list.getObjects(); //获取集合对象
        cursor1 = 0; //设置正向遍历游标的初始值
        cursor2 = products.size() -1; //设置逆向遍历游标的初始值
    }

    public void next() {
        if (cursor1 < products.size()) {
            cursor1++;
        }
    }

    public boolean isLast() {
        return (cursor1 == products.size());
    }

    public void previous() {
        if (cursor2 > -1) { cursor2--; }
    }

    public boolean isFirst() {
        return (cursor2 == -1);
    }

    public Object getNextItem() {
        return (Thing) products.get(cursor1);
    }

    public Object getPreviousItem() {
        return (Thing) products.get(cursor2);
    }

}
