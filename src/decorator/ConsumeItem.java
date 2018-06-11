package decorator;

/**
 * Created by Edge on 2016/4/18.
 */
public class ConsumeItem extends Item{

    public String getname(){
        return item.name;
    }

    public int getid(){
        return item.id;
    }

    public int getweight(){
        return item.weight;
    }

    public String gettype(){
        return item.type;
    }

    public void setname(String name){
        item.name = name;
    }

    public void setid(int id){
        item.id = id;
    }

    public void setweight(int weight){
        item.weight = weight;
    }

    public void settype(){
        item.type = "消耗品";
    }

    public void sethp(int hp){
        item.hp = hp;
    }

}
