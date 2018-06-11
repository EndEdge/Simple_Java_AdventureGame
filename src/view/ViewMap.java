package view;

import config.TextureConfig;
import data.MapData;
import model.Map;
import model.Player;
import observer.MapObserver;

import javax.swing.*;
import java.awt.*;

public class ViewMap extends JPanel implements MapObserver,TextureConfig{

    Map map;

    public ViewMap(){}

    public ViewMap(Map map){
        try {
            this.map = map;
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception{
        this.setPreferredSize(new Dimension(700, 700));
        this.setLayout(null);
        this.setBackground(Color.black);
    }

    public void paint(Graphics g) {
        //super.paint(g);

        MapData mapdata = map.getData(0);
        if (mapdata == null)
            return;
        for (int i = 0; i < MapHeight / eleSize; i++) {
            for (int j = 0; j < MapWidth / eleSize; j++) {
                ImageIcon icons1 = int2icon(mapdata.map1[i][j]);
                ImageIcon icons2 = int2icon(mapdata.map2[i][j]);
                g.drawImage(icons1.getImage(), getDrawX(j), getDrawY(i), eleSize, eleSize, null);
                g.drawImage(icons2.getImage(), getDrawX(j), getDrawY(i), eleSize, eleSize, null);
            }
        }
    }

    //将数组下标转化成对应的图片左上角坐标
    public int getDrawX(int j){
        int x = j*50;
        return x;
    }
    //将数组下标转化成对应的图片左上角坐标
    public int getDrawY(int i){
        int y = i*50;
        return y;
    }

    static ImageIcon int2icon(int num){
        if(num==0){
            return icon0;
        }else if(num==1){
            return icon1;
        }else if(num==2){
            return icon2;
        }else if(num==3){
            return icon3;
        }else if(num==100){
            return icon100;
        }else if(num==101){
            return icon101;
        }else if(num==102){
            return icon102;
        }else if(num==103){
            return icon103;
        }else if(num==150){
            return icon150;
        }
        return null;
    }

    public void mapDataUpdate(Map map){
        this.map = map;
        repaint();
    }
}
