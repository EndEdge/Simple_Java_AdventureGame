package decorator;

import adapter.EquipItemInterface;

/**
 * Created by Edge on 2016/4/18.
 */
public class EquipItem extends Item implements EquipItemInterface{

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
        item.type = "装备";
    }

    public void setatk(int atk){
        item.attack = atk;
    }

    public void setdef(int def){
        item.defence = def;
    }

    public void setsite(int x, int y){
        item.x = x;
        item.y = y;
    }

}
