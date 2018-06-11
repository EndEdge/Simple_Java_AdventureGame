package flyweight;

import javax.swing.*;

class Wall100 extends Wall{

    ImageIcon icon = new ImageIcon("100红树.png");

    public ImageIcon getImage() {
        return icon;
    }
}
