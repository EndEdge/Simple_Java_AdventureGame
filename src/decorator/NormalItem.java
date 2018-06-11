package decorator;

/**
 * Created by Edge on 2016/4/18.
 */
public class NormalItem extends ItemDecorator{

    public NormalItem(Item item){
        super(item);
    }

    public String getname(){
        return "普通的" + this.getname();
    }

}
