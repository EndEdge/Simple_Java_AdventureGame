package decorator;

/**
 * Created by Edge on 2016/4/18.
 */
public class FineItem extends ItemDecorator {
    public FineItem(Item item){
        super(item);
    }

    public String getname(){
        return "优良的" + this.getname();
    }

}
