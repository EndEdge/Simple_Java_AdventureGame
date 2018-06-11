package decorator;

/**
 * Created by Edge on 2016/4/18.
 */
public class ItemDecorator extends Item{

    private Item item;

    public ItemDecorator(Item item){
        this.item = item;
    }

    public String getname(){
        return item.getname();
    }

    public int getid(){
        return item.getid();
    }

    public int getweight(){
        return item.getweight();
    }

    public String gettype(){
        return item.gettype();
    }
}
