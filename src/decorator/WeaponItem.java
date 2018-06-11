package decorator;

/**
 * Created by Edge on 2016/4/18.
 */
public class WeaponItem extends ItemDecorator{

    public WeaponItem(Item item){
        super(item);
    }

    public String gettype(){
        return this.gettype() + " - 武器";
    }
}
