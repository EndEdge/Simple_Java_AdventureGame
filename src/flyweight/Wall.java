package flyweight;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edge on 2016/4/16.
 */
public abstract class Wall {

    public abstract ImageIcon getImage();

    public void draw(Graphics g, Coordinates coord){
        g.drawImage(this.getImage().getImage(), coord.getY()*50, coord.getX()*50, 50, 50, null);
    }

}
