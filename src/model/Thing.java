package model;

import adapter.ThingInterface;
import data.ThingData;

import javax.swing.*;

/**
 * 原型模式(PROTOTYPE)
 */
public class Thing implements Cloneable, ThingInterface{

    ImageIcon ticon = new ImageIcon("000空白.png");

    public ThingData thing = new ThingData();

    public Thing(){
        super();
    }

    public void setname(String name){
        thing.name = name;
    }

    public void setid(int id){
        thing.id = id;
    }

    public void setImg(ImageIcon icon){
        thing.icon = icon;
    }

    public void setposition(int x, int y){
        thing.x = x;
        thing.y = y;
    }

    public void setThing(ThingData thing){
        this.thing = thing;
    }

    public ImageIcon getImage(){
        return thing.icon;
    }

    public int getX(){
        return thing.x;
    }

    public int getY(){
        return thing.y;
    }

    public Thing clone(){
        Object obj = null;
        try{
            obj = super.clone();
            return (Thing)obj;
        } catch (CloneNotSupportedException e){
            System.out.println("clone error");
            return  null;
        }
    }

    public String getname() {
        return thing.name;
    }

    public boolean getmapid(int mapid){
        if(this.thing.mapid == mapid) {
            return true;
        }
        return false;
    }

    public boolean getplayer(int x, int y){
        if(this.getX() < x+20 && this.getX() > x-20 && getY() < y+20 && getY() > y-20){
            this.setImg(ticon);
            return true;
        }
        return false;
    }

}
