package model;

import config.PlayerConfig;
import config.TextureConfig;
import data.MapData;
import data.PlayerData;
import memento.PlayerMemento;

import java.awt.*;

public class Player extends Thread implements PlayerConfig, TextureConfig {

    private static Player instance = new Player();

    public Player() {
        super();
    }

    public static Player getInstance() {
        if(instance == null){
            instance = new Player();
        }
        return instance;
    }

    PlayerData playerdata = new PlayerData();

    public PlayerData getPlayerdata(){
        return playerdata;
    }

    public void setPosition(int x, int y, MapData mapdata) {
        this.x = x;
        this.y = y;
        playerdata.mapdata = mapdata;
    }

    public void setmapid(int mapid){
        this.playerdata.mapid = mapid;
    }

    public int getmapid(){
        return playerdata.mapid;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public PlayerMemento save(){
        return new PlayerMemento(this.playerdata, this.x, this.y);
    }

    public void restore(PlayerMemento memento){
        this.playerdata = memento.getData();
        this.x = memento.getX();
        this.y = memento.getY();
    }

    public void run() {
        while (true) {
            moveUD();
            moveLR();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //角色的初始位置
    static int x;
    static int y;

    //角色的偏移量
    int mx = 50;
    int my = 50;

    //角色是否移动
    public static boolean up = false;
    public static boolean down = false;
    public static boolean left = false;
    public static boolean right = false;

    //角色的朝向
    public static int towards = 2;

    //角色的移动累积量
    public static int up1 = 0;
    public static int down1 = 0;
    public static int left1 = 0;
    public static int right1 = 0;

    public void moveUD() {
        if (up) {
            //当按住上键时，给up1加1，当up1大于20时候又置为0，达成循环
            up1++;
            if (up1 >= 20) {
                up1 = 0;
            }
            //如果角色当前位置上方的数组值不为0（角色上方有物体挡着）：这里处理的是角色一个格子内部的移动，不能移动到上面一格
            if ((y / eleSize - 1) >= 0 && playerdata.mapdata.map2[y / eleSize - 1][x / eleSize] != 0) {
                int y1 = (y / eleSize - 1) * eleSize + eleSize / 2;
                int x1 = (x / eleSize) * eleSize + eleSize / 2;
                if ((y - y1) * (y - y1) >= eleSize * eleSize) {
                    y = y - step;
                    my = my - step;
                }
            } else if ((y / eleSize - 1) >= 0 && playerdata.mapdata.map2[y / eleSize - 1][x / eleSize] == 0) {//上方没物体，可以继续向上移动
                y = y - step;
                my = my - step;
            }
        } else if (down) {
            down1++;
            if (down1 >= 20) {
                down1 = 0;
            }
            if (playerdata.mapdata.map2[y / eleSize + 1][x / eleSize] != 0) {
                int y1 = (y / eleSize + 1) * eleSize + eleSize / 2;
                int x1 = (x / eleSize) * eleSize + eleSize / 2;
                if ((y - y1) * (y - y1) >= eleSize * eleSize) {
                    y = y + step;
                    my = my + step;
                }
            } else if (playerdata.mapdata.map2[y / eleSize + 1][x / eleSize] == 0) {
                y = y + step;
                my = my + step;
            }
        }
    }

    public void moveLR() {
        if (left) {
            left1++;
            if (left1 >= 20) {
                left1 = 0;
            }
            if ((x / eleSize - 1) >= 0 && playerdata.mapdata.map2[y / eleSize][x / eleSize - 1] != 0) {
                int y1 = (y / eleSize) * eleSize + eleSize / 2;
                int x1 = (x / eleSize - 1) * eleSize + eleSize / 2;
                if ((x - x1) * (x - x1) >= eleSize * eleSize) {
                    x = x - step;
                    mx = mx - step;
                }
            } else if ((x / eleSize - 1) >= 0 && playerdata.mapdata.map2[y / eleSize][x / eleSize - 1] == 0) {
                x = x - step;
                mx = mx - step;
            }
        } else if (right) {
            right1++;
            if (right1 >= 20) {
                right1 = 0;
            }
            if (playerdata.mapdata.map2[y / eleSize][x / eleSize + 1] != 0) {
                int y1 = (y / eleSize) * eleSize + eleSize / 2;
                int x1 = (x / eleSize + 1) * eleSize + eleSize / 2;
                if ((x - x1) * (x - x1) >= eleSize * eleSize) {
                    x = x + step;
                    mx = mx + step;
                }
            } else if (playerdata.mapdata.map2[y / eleSize][x / eleSize + 1] == 0) {
                x = x + step;
                mx = mx + step;
            }
        }
    }

    public static void draw(Graphics g) {
        //如果角色不在移动中
        if (!up && !down && !left && !right) {
            if (towards == 1) {//如果角色移动的最后朝向为上
                g.drawImage(walk1.getImage(), x - 25, y - 25, x + 55, y + 55, 0, 96 * 3, 96, 96 * 4, null);
            } else if (towards == 2) {//最后移动朝向下
                g.drawImage(walk1.getImage(), x - 25, y - 25, x + 55, y + 55, 0, 0, 96, 96, null);
            } else if (towards == 3) {//最后移动朝向左
                g.drawImage(walk1.getImage(), x - 25, y - 25, x + 55, y + 55, 0, 96, 96, 96 * 2, null);
            } else if (towards == 4) {//最后移动朝向右
                g.drawImage(walk1.getImage(), x - 25, y - 25, x + 55, y + 55, 0, 96 * 2, 96, 96 * 3, null);
            }
        } else {//如果角色在移动中
            if (up) {
                //通过up1的值，来决定画哪一张图片
                if (up1 < 5) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 0, 96 * 3, 96, 96 * 4, null);
                } else if (up1 < 10) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96, 96 * 3, 96 * 2, 96 * 4, null);
                } else if (up1 < 15) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96 * 2, 96 * 3, 96 * 3, 96 * 4, null);
                } else {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96 * 3, 96 * 3, 96 * 4, 96 * 4, null);
                }
            } else if (down) {
                if (down1 < 5) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 0, 0, 96, 96, null);
                } else if (down1 < 10) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96, 0, 96 * 2, 96, null);
                } else if (down1 < 15) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96 * 2, 0, 96 * 3, 96, null);
                } else {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96 * 3, 0, 96 * 4, 96, null);
                }
            } else if (left) {
                if (left1 < 5) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 0, 96, 96, 96 * 2, null);
                } else if (left1 < 10) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96, 96, 96 * 2, 96 * 2, null);
                } else if (left1 < 15) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96 * 2, 96, 96 * 3, 96 * 2, null);
                } else {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96 * 3, 96, 96 * 4, 96 * 2, null);
                }

            } else if (right) {
                if (right1 < 5) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 0, 96 * 2, 96, 96 * 3, null);
                } else if (right1 < 10) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96, 96 * 2, 96 * 2, 96 * 3, null);
                } else if (right1 < 15) {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96 * 2, 96 * 2, 96 * 3, 96 * 3, null);
                } else {
                    g.drawImage(walk.getImage(), x - 25, y - 25, x + 55, y + 55, 96 * 3, 96 * 2, 96 * 4, 96 * 3, null);
                }
            }
        }
    }
}

