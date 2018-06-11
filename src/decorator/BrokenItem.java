package decorator;

/**
 * Created by Edge on 2016/4/18.
 */
public class BrokenItem extends ItemDecorator{

    public BrokenItem(Item item){
        super(item);
    }

    public String getname(){
        return "损坏的" + this.getname();
    }
}
