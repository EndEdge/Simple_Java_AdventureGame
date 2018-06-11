package config;

import javax.swing.*;

public interface PlayerConfig {

    //角色的步长
    int step = 5;

    ImageIcon walk = new ImageIcon("角色行走图.png");
    ImageIcon walk1 = new ImageIcon("角色停顿图.png");
}
