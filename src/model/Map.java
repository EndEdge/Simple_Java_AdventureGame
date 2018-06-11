package model;

import data.MapData;
import observer.MapObserver;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Map {

    ArrayList mapdata = new ArrayList();
    ArrayList mapobserver = new ArrayList();

    static int[][] map1;
    static int[][] map2;
    static int[][] map3;

    public Map(){
        super();
    }

    public Map(MapData[] data){
        for(int i=0; i<data.length; i++){

        }
    }

    public void addData(String mapPath){
        MapData data = new MapData();
        data.mapPath = mapPath;
        readfile(mapPath);
        data.map1 = this.map1;
        data.map2 = this.map2;
        this.mapdata.add(data);
    }

    public void addData(MapData data){
        readfile(data.mapPath);
        data.map1 = this.map1;
        data.map2 = this.map2;
        this.mapdata.add(data);
    }

    public MapData getData(int idx){
        return (MapData)(mapdata.get(idx));
    }

    public int size(){
        return mapdata.size();
    }

    public void registerOberver(MapObserver o){
        mapobserver.add(o);
    }

    public void removeOberver(MapObserver o){
        mapobserver.remove(o);
    }

    public void changeModel(Map map){
        mapdata.clear();
        for (int i=0; i<map.size(); i++){
            this.addData(map.getData(i));
        }
        mapDataUpdate();
    }

    public void mapDataUpdate(){
        for(Iterator i = mapobserver.iterator(); i.hasNext(); ){
            MapObserver o = (MapObserver)(i.next());
            o.mapDataUpdate(this);
        }
    }

    public void readfile(String path){
        try{
            //从path路径下的地图文件中得到文件输入流
            FileInputStream fis = new FileInputStream(path);
            //将文件输入流包装成基本数据输入流
            DataInputStream dis = new DataInputStream(fis);
            //按保存时候的顺序依次读出地图文件中的三个地图数组
            int i = dis.readInt();
            int j = dis.readInt();
            map1 = new int[i][j];
            map2 = new int[i][j];
            map3 = new int[i][j];
            for(int ii=0;ii<i;ii++){
                for(int jj=0;jj<j;jj++){
                    map1[ii][jj] = dis.readInt();
                    map2[ii][jj] = dis.readInt();
                    map3[ii][jj] = dis.readInt();
                }
            }
            dis.close();
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
