package model;

import data.MapData;

public class MapSite {
    int inx;
    int iny;
    int outx;
    int outy;
    MapData mapdata;

    public void enter(int x, int y){
        this.inx = x;
        this.iny = y;
    }

    public void exit(int x, int y){
        this.outx = x;
        this.outy = y;
    }

    public void setMapdata(MapData mapdata){
        this.mapdata = mapdata;
    }
}
