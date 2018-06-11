package controller;

import abstractFactory.DoorFactory;
import abstractFactory.Fdoor;
import abstractFactory.NoLockDoorFactory;
import config.TextureConfig;
import data.MapData;
import flyweight.Wall;
import flyweight.WallFactory;
import model.Map;
import model.Player;
import model.Thing;
import view.ViewMap;
import view.ThingModel;
import view.ViewThing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdventureGame extends JFrame implements TextureConfig{
    Map map = new Map();
    ViewMap viewmap = new ViewMap(map);
    Player p = new Player();

    //Thing t00 = new Thing();
    //Thing t01 = new Thing();
    ImageIcon ticon = new ImageIcon();
    ThingModel thingmodel = new ThingModel();
    ViewThing viewthing = new ViewThing(thingmodel);
    Thing[] t = new Thing[2];

    Wall wall1,wall2;
    WallFactory wallFactory;

    DoorFactory doorFactory;
    Fdoor door1,door2;

    //JScrollPane jScrollPane1 = new JScrollPane();

    public AdventureGame(){
        init();
    }

    public void init(){
        MapData mapdata = new MapData();
        mapdata.mapPath = "worldmap.map";

        p = Player.getInstance();
        p.setPosition(275, 175, mapdata);
        p.setmapid(0);
        KeyMonitor lk = new KeyMonitor();
        this.addKeyListener(lk);

        map.addData(mapdata);
        map.registerOberver(viewmap);

        wallFactory = WallFactory.getInstance();
        wall1 = wallFactory.getWall(1);
        wall2 = wallFactory.getWall(2);

        doorFactory = new NoLockDoorFactory();
        door1 = doorFactory.createdoor();
        door2 = doorFactory.createdoor();

        this.getContentPane().setLayout(null);

        viewmap.setBounds(new Rectangle(10,10,600,600));
        this.getContentPane().add(viewmap, null);

        this.setSize(800, 640);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        //this.setLayout(new FlowLayout());
        this.setVisible(true);

        p.start();
        new Thread(new PaintThread()).start();

        t[0] = new Thing();
        t[1] = new Thing();
        t[0].setImg(ticon = new ImageIcon("200树桩.png"));
        t[0].setposition(5,5);
        t[1].setImg(ticon = new ImageIcon("200树桩.png"));
        t[1].setposition(5,7);
        thingmodel.join(t[0]);
        thingmodel.join(t[1]);
        thingmodel.registerObserver(viewthing);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        viewthing.draw(g);
        p.draw(g);
    }

    public static void main(String[] args){
        AdventureGame g = new AdventureGame();
    }

    private class PaintThread extends Thread{

        @Override
        public void run() {
            while(true){
                //if(t00.getmapid(p.getmapid()))
                //    t00.beApproch(viewthing);
                /*if(t[0].getplayer(p.getX(),p.getY())) {
                   // t[0].setImg(ticon = new ImageIcon("000空白.png"));
                    ThingModel m = new ThingModel(t);
                    thingmodel.changeModel(m);
                }
                if(t[1].getplayer(p.getX(),p.getY())) {
                    //t[1].setImg(ticon = new ImageIcon("000空白.png"));
                    ThingModel m = new ThingModel(t);
                    thingmodel.changeModel(m);
                }*/
                repaint();

                try{
                    Thread.sleep(20);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class KeyMonitor extends KeyAdapter {
        //当按键按下
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            switch (code) {
                case KeyEvent.VK_UP:
                    Player.up = true;
                    Player.towards = 1;
                    break;
                case KeyEvent.VK_DOWN:
                    Player.down = true;
                    Player.towards = 2;
                    break;
                case KeyEvent.VK_LEFT:
                    Player.left = true;
                    Player.towards = 3;
                    break;
                case KeyEvent.VK_RIGHT:
                    Player.right = true;
                    Player.towards = 4;
                    break;

                default:
                    break;
            }
        }

        //当按键释放
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            switch (code) {
                case KeyEvent.VK_UP:
                    Player.up = false;
                    Player.up1 = 0;
                    break;
                case KeyEvent.VK_DOWN:
                    Player.down = false;
                    Player.down1 = 0;
                    break;
                case KeyEvent.VK_LEFT:
                    Player.left = false;
                    Player.left1 = 0;
                    break;
                case KeyEvent.VK_RIGHT:
                    Player.right = false;
                    Player.right1 = 0;
                    break;

                default:
                    break;
            }
        }
    }
}

